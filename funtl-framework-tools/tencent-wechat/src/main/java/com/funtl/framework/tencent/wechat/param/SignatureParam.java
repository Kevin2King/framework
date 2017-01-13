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

package com.funtl.framework.tencent.wechat.param;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信身份认证参数
 *
 * @author ChengNing
 * @date 2014年12月6日
 */
public class SignatureParam {

	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;

	public SignatureParam(HttpServletRequest request) {
		signature = request.getParameter(WechatParamName.SIGNATURE);
		timestamp = request.getParameter(WechatParamName.TIMESTAMP);
		nonce = request.getParameter(WechatParamName.NONCE);
		echostr = request.getParameter(WechatParamName.ECHOSTR);
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getEchostr() {
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}


}
