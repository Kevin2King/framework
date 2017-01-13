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

package com.funtl.framework.tencent.wechat.jsapi;

import com.funtl.framework.tencent.wechat.token.TokenProxy;
import com.funtl.framework.tencent.wechat.util.RandomStringGenerator;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JS SDK 管理类
 * <p>参考<a href="http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html">开发文档</a></p>
 * Created by xuwen on 2015-12-11.
 */
public class JsApiManager {

	private static Logger logger = LoggerFactory.getLogger(JsApiManager.class);

	/**
	 * 给需要调用JS SDK的URL签名
	 *
	 * @param url
	 * @return
	 */
	public static JsApiParam signature(String url) {
		StringBuffer signatureSource = new StringBuffer();
		String nonceStr = RandomStringGenerator.generate();
		String timestamp = Long.toString(System.currentTimeMillis() / 1000);
		String jsapiTicket = TokenProxy.jsApiTicket();
		signatureSource.append("jsapi_ticket=").append(jsapiTicket);
		signatureSource.append("&noncestr=").append(nonceStr);
		signatureSource.append("&timestamp=").append(timestamp);
		signatureSource.append("&url=").append(url);
		logger.info("sign source : " + signatureSource);
		String signature = DigestUtils.sha1Hex(signatureSource.toString());
		logger.info("sign : " + signature);
		return new JsApiParam(url, jsapiTicket, nonceStr, timestamp, signature);
	}

}
