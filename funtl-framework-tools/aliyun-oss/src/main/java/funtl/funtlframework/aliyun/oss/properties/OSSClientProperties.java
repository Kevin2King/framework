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

package funtl.funtlframework.aliyun.oss.properties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * OSSClientProperties.
 *
 * @author Lusifer Lee
 */
public final class OSSClientProperties {

	private OSSClientProperties() {

	}

	private static Logger logger = LoggerFactory.getLogger(OSSClientProperties.class);

	private static Properties OSSKeyProperties = new Properties();
	// 阿里云是否启用配置
	/**
	 * 用户状态设置.
	 */
	public static boolean useStatus = false;
	/**
	 * bucket名称.
	 */
	public static String bucketName = "";
	/**
	 * .
	 */
	public static String key = "";
	/**
	 * .
	 */
	public static String secret = "";
	/**
	 * .
	 */
	public static boolean autoCreateBucket = false;
	/**
	 * .
	 */
	public static String ossEndPoint = "";
	/**
	 * .
	 */
	public static boolean useCDN = false;
	/**
	 * .
	 */
	public static String cdnEndPoint = "";
	/**
	 * .
	 */
	public static boolean useLocalStorager = false;
	/**
	 * .
	 */
	public static String uploadBasePath = "upload";
	/**
	 * .
	 */
	public static boolean useAsynUploader = false;

	static {
		String OSSKeyPath = SystemUtil.getProjectClassesPath() + "OSSKey.properties";
		// 生成文件输入流
		FileInputStream inpf = null;
		try {
			inpf = new FileInputStream(new File(OSSKeyPath));
			OSSKeyProperties.load(inpf);

			useStatus = "true".equalsIgnoreCase((String) OSSKeyProperties.get("useStatus")) ? true : false;
			bucketName = (String) OSSKeyProperties.get("bucketName");
			key = (String) OSSKeyProperties.get("key");
			secret = (String) OSSKeyProperties.get("secret");
			autoCreateBucket = "true".equalsIgnoreCase((String) OSSKeyProperties.get("autoCreateBucket")) ? true : false;

			ossEndPoint = (String) OSSKeyProperties.get("ossEndPoint");
			useCDN = "true".equalsIgnoreCase((String) OSSKeyProperties.get("useCDN")) ? true : false;
			cdnEndPoint = (String) OSSKeyProperties.get("cdnEndPoint");

			useLocalStorager = "true".equalsIgnoreCase((String) OSSKeyProperties.get("useLocalStorager")) ? true : false;
			uploadBasePath = (String) OSSKeyProperties.get("uploadBasePath");
			useAsynUploader = "true".equalsIgnoreCase((String) OSSKeyProperties.get("useAsynUploader")) ? true : false;
		} catch (Exception e) {
			logger.warn("系统未找到指定文件：OSSKey.properties --> 系统按照ueditor默认配置执行。");
		}
	}

}
