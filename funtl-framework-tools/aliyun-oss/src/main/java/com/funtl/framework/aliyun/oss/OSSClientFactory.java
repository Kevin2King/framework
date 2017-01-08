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

package com.funtl.framework.aliyun.oss;

import com.funtl.framework.aliyun.oss.properties.OSSClientProperties;

import com.aliyun.oss.OSSClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * OSSClient是OSS服务的Java客户端，它为调用者提供了一系列的方法，用于和OSS服务进行交互<br>
 *
 * @create date : 2014年10月28日 上午11:20:56
 * @Author XieXianbin<a.b@hotmail.com>
 * @Source Repositories Address: <https://github.com/qikemi/UEditor-for-aliyun-OSS>
 */
public class OSSClientFactory {

	private static Logger logger = LoggerFactory.getLogger(OSSClientFactory.class);
	private static OSSClient client = null;

	/**
	 * 新建OSSClient
	 *
	 * @return
	 */
	public static OSSClient createOSSClient() {
		if (null == client) {
			client = new OSSClient(OSSClientProperties.ossEndPoint, OSSClientProperties.key, OSSClientProperties.secret);
			logger.info("First CreateOSSClient success.");
		}
		return client;
	}

}
