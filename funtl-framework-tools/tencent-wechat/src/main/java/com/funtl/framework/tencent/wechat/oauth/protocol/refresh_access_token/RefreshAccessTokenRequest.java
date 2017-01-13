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

package com.funtl.framework.tencent.wechat.oauth.protocol.refresh_access_token;

import com.funtl.framework.tencent.wechat.common.Config;

/**
 * 响应：刷新access_token（如果需要）
 * Created by xuwen on 2015-12-11.
 */
public class RefreshAccessTokenRequest {

	public RefreshAccessTokenRequest(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	private String appid = Config.instance().getAppid();
	private String grant_type = "refresh_token";
	private String refresh_token;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	@Override
	public String toString() {
		return "RefreshAccessTokenRequest{" + "appid='" + appid + '\'' + ", grant_type='" + grant_type + '\'' + ", refresh_token='" + refresh_token + '\'' + '}';
	}
}
