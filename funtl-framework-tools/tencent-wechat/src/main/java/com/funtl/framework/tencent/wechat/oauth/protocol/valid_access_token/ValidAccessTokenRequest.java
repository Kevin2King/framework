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

package com.funtl.framework.tencent.wechat.oauth.protocol.valid_access_token;

/**
 * 响应：检验授权凭证（access_token）是否有效
 * Created by xuwen on 2015-12-11.
 */
public class ValidAccessTokenRequest {

	public ValidAccessTokenRequest(String access_token, String openid) {
		this.access_token = access_token;
		this.openid = openid;
	}

	private String access_token;
	private String openid;

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

	@Override
	public String toString() {
		return "ValidAccessTokenRequest{" + "access_token='" + access_token + '\'' + ", openid='" + openid + '\'' + '}';
	}
}
