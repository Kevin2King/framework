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

package com.funtl.framework.tencent.wechat.oauth;

/**
 * OAuth API 调用异常
 * Created by xuwen on 2015-12-11.
 */
public class OAuthException extends Exception {

	public OAuthException() {
	}

	public OAuthException(String errcode, String errmsg) {
		this.errcode = errcode;
		this.errmsg = errmsg;
	}

	private String errcode;
	private String errmsg;

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return "OAuthException{" + "errcode='" + errcode + '\'' + ", errmsg='" + errmsg + '\'' + '}';
	}
}
