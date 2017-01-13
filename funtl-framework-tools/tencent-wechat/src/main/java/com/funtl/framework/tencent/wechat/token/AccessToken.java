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

package com.funtl.framework.tencent.wechat.token;

import com.funtl.framework.tencent.wechat.common.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Access token实体模型
 *
 * @author ChengNing
 * @date 2014年12月12日
 */
public class AccessToken extends Token {

	private static Logger logger = LoggerFactory.getLogger(AccessToken.class);
	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";


	@Override
	protected String tokenName() {
		return "access_token";
	}

	@Override
	protected String expiresInName() {
		return "expires_in";
	}

	/**
	 * 组织accesstoken的请求utl
	 */
	@Override
	protected String accessTokenUrl() {
		String appid = Config.instance().getAppid();
		String appsecret = Config.instance().getAppSecret();
		String url = ACCESS_TOKEN_URL + "&appid=" + appid + "&secret=" + appsecret;
		logger.info("创建获取access_token url");
		return url;
	}


}
