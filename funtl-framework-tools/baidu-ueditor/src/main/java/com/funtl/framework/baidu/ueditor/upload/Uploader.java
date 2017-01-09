/*
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.funtl.framework.baidu.ueditor.upload;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.funtl.framework.aliyun.oss.BucketService;
import com.funtl.framework.aliyun.oss.OSSClientFactory;
import com.funtl.framework.aliyun.oss.properties.OSSClientProperties;
import com.funtl.framework.aliyun.oss.properties.SystemUtil;
import com.funtl.framework.baidu.ueditor.define.State;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 同步上传文件到阿里云OSS<br>
 *
 * @create date : 2014年10月28日 上午22:15:00
 * @Author XieXianbin<a.b@hotmail.com>
 * @Source Repositories Address:
 * <https://github.com/qikemi/UEditor-for-aliyun-OSS>
 */
public class Uploader {
	private static Logger logger = LoggerFactory.getLogger(Uploader.class);

	private HttpServletRequest request = null;
	private Map<String, Object> conf = null;

	public Uploader(HttpServletRequest request, Map<String, Object> conf) {
		this.request = request;
		this.conf = conf;
	}

	public final State doExec() {
		String filedName = (String) this.conf.get("fieldName");
		State state = null;

		if ("true".equals(this.conf.get("isBase64"))) {
			state = Base64Uploader.save(this.request.getParameter(filedName), this.conf);
		} else {
			state = BinaryUploader.save(this.request, this.conf);
			JSONObject stateJson = new JSONObject(state.toJSONString());
			// 判别云同步方式
			if (OSSClientProperties.useStatus) {

				String bucketName = OSSClientProperties.bucketName;
				OSSClient client = OSSClientFactory.createOSSClient();
				// auto create Bucket to default zone
				if (OSSClientProperties.autoCreateBucket) {
					Bucket bucket = BucketService.create(client, bucketName);
					logger.debug("Bucket 's " + bucket.getName() + " Created.");
				}

				// upload type
				if (OSSClientProperties.useAsynUploader) {
					AsynUploaderThreader asynThreader = new AsynUploaderThreader();
					asynThreader.init(stateJson, client, this.request);
					Thread uploadThreader = new Thread(asynThreader);
					uploadThreader.start();
				} else {
					SynUploader synUploader = new SynUploader();
					synUploader.upload(stateJson, client, this.request);
				}

				// storage type
				if (false == OSSClientProperties.useLocalStorager) {
					String uploadFilePath = (String) this.conf.get("rootPath") + (String) stateJson.get("url");
					File uploadFile = new File(uploadFilePath);
					if (uploadFile.isFile() && uploadFile.exists()) {
						uploadFile.delete();
					}
				}

				state.putInfo("url", OSSClientProperties.ossEndPoint + stateJson.getString("url"));
			} else {
				state.putInfo("url", "/" + SystemUtil.getProjectName() + stateJson.getString("url"));
			}
		}

		logger.debug(state.toJSONString());
		return state;
	}
}
