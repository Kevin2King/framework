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

package com.funtl.framework.share.login.wechat;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.JsonNode;
import com.funtl.framework.core.mapper.JsonMapper;
import com.funtl.framework.core.utils.JedisUtils;

import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信第三方登录
 * Created by 钟廷员 on 2016/11/24.
 */
public class WechatLoginUtil {
	private static Logger logger = LoggerFactory.getLogger(WechatLoginUtil.class);

	// 获取access token链接
	private static final String AUTHORIZE_URL = "https://open.weixin.qq.com/connect/qrconnect";
	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
	private static final String USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo";
	private static final JsonMapper jsonMapper = JsonMapper.getInstance();
	private static final String STATE_CACHE_ID = "wechat_third_login_state_cache_id_";
	public static final int LOGIN_CACHE_TIMEOUT = 600;
	public static String APPID = "appId";
	public static String APP_SECRET = "appKey";
	public static String NOTUFY_URL = "redirectUri";

	/**
	 * @param appId
	 * @param notufyUrl 微信登录重定向URL
	 * @param request
	 * @return
	 */
	public static String getAuthorizeURL(String appId, String notufyUrl, HttpServletRequest request) {
		String state = UUID.randomUUID().toString().replace("-", "");// 用于保持请求和回调的状态，授权请求后原样带回给第三方。该参数可用于防止csrf攻击
		JedisUtils.set(STATE_CACHE_ID.concat(state), request.getSession().getId(), LOGIN_CACHE_TIMEOUT);
		return AUTHORIZE_URL.concat("?appid=").concat(appId).concat("&response_type=code&scope=snsapi_login&redirect_uri=").concat(notufyUrl).concat("&state=").concat(state);
	}

	/**
	 * @param appId
	 * @param appSecret
	 * @param request
	 * @return
	 * @throws WechatLoginException
	 */
	public static Info getLoginMsg(String appId, String appSecret, HttpServletRequest request) throws WechatLoginException {
		String code = request.getParameter("code");

		// 获取access_token和openid
		String access_token;
		String openid;
		try {
			String access_token_json = EntityUtils.toString(Request.Get(ACCESS_TOKEN_URL.concat("?grant_type=authorization_code&appid=").concat(appId).concat("&secret=").concat(appSecret).concat("&code=").concat(code)).execute().returnResponse().getEntity());
			JsonNode access_token_jn = jsonMapper.readTree(access_token_json);
			if (access_token_jn.get("access_token") == null)
				throw new WechatLoginException("获取access_token失败，失败返回：".concat(access_token_json));
			access_token = access_token_jn.get("access_token").textValue();
			openid = access_token_jn.get("openid").textValue();
		} catch (IOException e) {
			throw new WechatLoginException("获取access_token和openid时IOException", e);
		}

		// 获取unionid和基本信息
		try {
			String msg_json = EntityUtils.toString(Request.Get(USER_INFO_URL.concat("?access_token=").concat(access_token).concat("&openid=").concat(openid)).execute().returnResponse().getEntity(), "UTF-8");
			JsonNode msg_jn = jsonMapper.readTree(msg_json);
			return new Info(msg_jn.get("nickname").textValue(), msg_jn.get("headimgurl").textValue(), String.valueOf(msg_jn.get("sex").intValue()), msg_jn.get("unionid").textValue());
		} catch (IOException e) {
			throw new WechatLoginException("通过code获取access_token异常", e);
		}
	}

	public static class WechatLoginException extends Exception {
		WechatLoginException(String message) {
			super(message);
		}

		WechatLoginException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	public static class Info {
		private String nickname;
		private String headimgurl;
		private String sex;
		private String unionid;

		public Info(String nickname, String headimgurl, String sex, String unionid) {
			this.nickname = nickname;
			this.headimgurl = headimgurl;
			this.sex = sex;
			this.unionid = unionid;
		}

		public String getNickname() {
			return nickname;
		}

		public String getHeadimgurl() {
			return headimgurl;
		}

		public String getSex() {
			return sex;
		}

		public String getUnionid() {
			return unionid;
		}
	}
}
