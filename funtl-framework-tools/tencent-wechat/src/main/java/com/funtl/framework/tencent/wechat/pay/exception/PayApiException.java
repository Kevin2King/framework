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

package com.funtl.framework.tencent.wechat.pay.exception;


import javax.xml.bind.annotation.XmlRootElement;

import com.funtl.framework.tencent.wechat.pay.PayCode;

/**
 * 支付API调用异常
 * return_code=FAIL
 * <p/>
 * Created by xuwen on 2015-12-11.
 */
@XmlRootElement(name = "xml")
public class PayApiException extends Exception {

	public PayApiException() {
	}


	public PayApiException(PayCode payCode, String return_msg) {
		this.return_code = payCode.toString();
		this.return_msg = return_msg;
	}

	public PayApiException(String return_code, String return_msg) {
		this.return_code = return_code;
		this.return_msg = return_msg;
	}

	private String return_code;
	private String return_msg;

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	@Override
	public String toString() {
		return "PayApiException{" + "return_code='" + return_code + '\'' + ", return_msg='" + return_msg + '\'' + '}';
	}
}
