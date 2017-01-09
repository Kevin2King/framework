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

package com.funtl.framework.baidu.ueditor.hunter;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.aliyun.oss.OSSClient;
import com.funtl.framework.aliyun.oss.BucketService;
import com.funtl.framework.aliyun.oss.OSSClientFactory;
import com.funtl.framework.aliyun.oss.ObjectService;
import com.funtl.framework.aliyun.oss.properties.OSSClientProperties;
import com.funtl.framework.aliyun.oss.properties.SystemUtil;
import com.funtl.framework.baidu.ueditor.PathFormat;
import com.funtl.framework.baidu.ueditor.define.AppInfo;
import com.funtl.framework.baidu.ueditor.define.BaseState;
import com.funtl.framework.baidu.ueditor.define.MultiState;
import com.funtl.framework.baidu.ueditor.define.State;

import org.apache.commons.io.FileUtils;

public class FileManager {

	private String dir = null;
	private String rootPath = null;
	private String[] allowFiles = null;
	private int count = 0;

	public FileManager(Map<String, Object> conf) {

		this.rootPath = (String) conf.get("rootPath");
		this.dir = this.rootPath + (String) conf.get("dir");
		this.allowFiles = this.getAllowFiles(conf.get("allowFiles"));
		this.count = (Integer) conf.get("count");

	}

	public State listFile(int index) {

		File dir = new File(this.dir);
		State state = null;

		Collection<File> list = null;

		if (OSSClientProperties.useStatus) {
			// 从阿里云OSS服务器中获取文件
			// 获取prefix
			String prefix = this.dir.replace(SystemUtil.getProjectRootPath(), "");
			prefix = prefix.replaceFirst("/", "");
			// 获取路径
			OSSClient client = OSSClientFactory.createOSSClient();
			if (OSSClientProperties.autoCreateBucket) {
				BucketService.create(client, OSSClientProperties.bucketName);
			}
			List<String> objectList = ObjectService.listObject(client, OSSClientProperties.bucketName, null, prefix);

			if (index < 0 || index > objectList.size()) {
				state = new MultiState(true);
			} else {
				Object[] fileList = Arrays.copyOfRange(objectList.toArray(), index, index + this.count);
				state = this.getOSSState(fileList);
			}

			state.putInfo("start", index);
			state.putInfo("total", objectList.size());
			// 处理连接问题

		} else {
			// 从文件夹中获取文件
			if (!dir.exists()) {
				return new BaseState(false, AppInfo.NOT_EXIST);
			}

			if (!dir.isDirectory()) {
				return new BaseState(false, AppInfo.NOT_DIRECTORY);
			}

			list = FileUtils.listFiles(dir, this.allowFiles, true);

			if (index < 0 || index > list.size()) {
				state = new MultiState(true);
			} else {
				Object[] fileList = Arrays.copyOfRange(list.toArray(), index, index + this.count);
				state = this.getState(fileList);
			}

			state.putInfo("start", index);
			state.putInfo("total", list.size());
		}

		return state;

	}

	private State getState(Object[] files) {

		MultiState state = new MultiState(true);
		BaseState fileState = null;

		File file = null;

		for (Object obj : files) {
			if (obj == null) {
				break;
			}
			file = (File) obj;
			fileState = new BaseState(true);
			fileState.putInfo("url", "/" + SystemUtil.getProjectName() + PathFormat.format(this.getPath(file)));
			state.addState(fileState);
		}

		return state;

	}

	// 处理ailiyun数据
	private State getOSSState(Object[] files) {

		MultiState state = new MultiState(true);
		BaseState fileState = null;

		for (Object obj : files) {
			if (obj == null) {
				break;
			}

			fileState = new BaseState(true);
			fileState.putInfo("url", PathFormat.format(OSSClientProperties.ossEndPoint + obj));
			state.addState(fileState);
		}

		return state;

	}

	private String getPath(File file) {
		String path = file.getAbsolutePath();

		String str = path.replace(this.rootPath.replaceAll("\\/", "\\\\"), "\\");

		return str;
	}

	private String[] getAllowFiles(Object fileExt) {

		String[] exts = null;
		String ext = null;

		if (fileExt == null) {
			return new String[0];
		}

		exts = (String[]) fileExt;

		for (int i = 0, len = exts.length; i < len; i++) {

			ext = exts[i];
			exts[i] = ext.replace(".", "");

		}

		return exts;

	}

}
