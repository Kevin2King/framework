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

package com.funtl.framework.tencent.wechat.response;

import javax.xml.bind.annotation.XmlElement;

/**
 * 指定客服
 *
 * @author Zhangxs
 * @version 2015-7-7
 */

public class TransInfoResponse {
	private String KfAccount;//指定会话接入的客服账号

	public TransInfoResponse() {
		super();
	}

	public TransInfoResponse(String kfAccount) {
		super();
		KfAccount = kfAccount;
	}

	@XmlElement(name = "KfAccount")
	public String getKfAccount() {
		return KfAccount;
	}

	public void setKfAccount(String kfAccount) {
		KfAccount = kfAccount;
	}

}
