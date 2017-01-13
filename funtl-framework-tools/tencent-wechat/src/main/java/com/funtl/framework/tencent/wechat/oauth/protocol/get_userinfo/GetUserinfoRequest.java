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

package com.funtl.framework.tencent.wechat.oauth.protocol.get_userinfo;

/**
 * 请求：拉取用户信息(需scope为 snsapi_userinfo)
 * Created by xuwen on 2015-12-11.
 */
public class GetUserinfoRequest {

	public GetUserinfoRequest(String access_token, String openid) {
		this.access_token = access_token;
		this.openid = openid;
	}

	public GetUserinfoRequest(String access_token, String openid, String lang) {
		this.access_token = access_token;
		this.openid = openid;
		this.lang = lang;
	}

	private String access_token;
	private String openid;
	private String lang = "zh_CN";

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Override
	public String toString() {
		return "GetUserinfoRequest{" + "access_token='" + access_token + '\'' + ", openid='" + openid + '\'' + ", lang='" + lang + '\'' + '}';
	}
}
