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

package com.funtl.framework.tencent.wechat.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ChengNing
 * @date 2014年12月8日
 */
public class Config {

	private static Logger logger = LoggerFactory.getLogger(Config.class);

	private static final String configFile = "/wechat4j.properties";

	private String url;
	private String token;
	private String encodingAESKey;
	private String appid;
	private String appSecret;
	private String mchId;
	private String mchKey;
	private String accessTokenServer;
	private String jsApiTicketServer;
	private static Config config = new Config();

	private Config() {
		Properties p = new Properties();
		InputStream inStream = this.getClass().getResourceAsStream(configFile);
		if (inStream == null) {
			logger.error("根目录下找不到wechat4j.properties文件");
			return;
		}
		try {
			p.load(inStream);
			this.url = p.getProperty("wechat.url");
			if (StringUtils.isNotBlank(url)) this.url = this.url.trim();
			this.encodingAESKey = p.getProperty("wechat.encodingaeskey");
			if (StringUtils.isNotBlank(encodingAESKey)) this.encodingAESKey = this.encodingAESKey.trim();
			this.token = p.getProperty("wechat.token");
			if (StringUtils.isNotBlank(token)) this.token = this.token.trim();
			this.appid = p.getProperty("wechat.appid");
			if (StringUtils.isNotBlank(appid)) this.appid = this.appid.trim();
			this.appSecret = p.getProperty("wechat.appsecret");
			if (StringUtils.isNotBlank(appSecret)) this.appSecret = this.appSecret.trim();
			this.mchId = p.getProperty("wechat.mch.id");
			if (StringUtils.isNotBlank(url)) this.mchId = this.mchId.trim();
			this.mchKey = p.getProperty("wechat.mch.key");
			if (StringUtils.isNotBlank(mchKey)) this.mchKey = this.mchKey.trim();
			this.accessTokenServer = p.getProperty("wechat.accessToken.server.class");
			if (StringUtils.isNotBlank(accessTokenServer)) this.accessTokenServer = this.accessTokenServer.trim();
			this.jsApiTicketServer = p.getProperty("wechat.ticket.jsapi.server.class");
			if (StringUtils.isNotBlank(jsApiTicketServer)) this.jsApiTicketServer = this.jsApiTicketServer.trim();
			inStream.close();
		} catch (IOException e) {
			logger.error("load wechat4j.properties error,class根目录下找不到wechat4j.properties文件");
			e.printStackTrace();
		}
		logger.info("load wechat4j.properties success");
	}

	public static Config instance() {
		return config;
	}

	public String getToken() {
		return token;
	}

	public String getAppid() {
		return appid;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public String getMchId() {
		return mchId;
	}

	public String getMchKey() {
		return mchKey;
	}

	public String getUrl() {
		return url;
	}

	public String getEncodingAESKey() {
		return encodingAESKey;
	}

	public String getAccessTokenServer() {
		return accessTokenServer;
	}

	public String getJsApiTicketServer() {
		return jsApiTicketServer;
	}


}
