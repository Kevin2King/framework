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

package com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api;

import java.io.Serializable;
import java.util.Map;

import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.internal.mapping.ApiField;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.internal.util.StringUtils;

/**
 * API基础响应信息。
 *
 * @author fengsheng
 */
public abstract class AlipayResponse implements Serializable {

	private static final long serialVersionUID = 5014379068811962022L;

	@ApiField("code")
	private String code;

	@ApiField("msg")
	private String msg;

	@ApiField("sub_code")
	private String subCode;

	@ApiField("sub_msg")
	private String subMsg;

	private String body;
	private Map<String, String> params;

	/**
	 * 废弃方法，请使用getCode替换
	 *
	 * @return
	 */
	@Deprecated
	public String getErrorCode() {
		return this.getCode();
	}

	/**
	 * 废弃方法，请使用setCode替换
	 *
	 * @param errorCode
	 */
	@Deprecated
	public void setErrorCode(String errorCode) {
		this.setCode(errorCode);
	}

	/**
	 * Getter method for property <tt>code</tt>.
	 *
	 * @return property value of code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter method for property <tt>code</tt>.
	 *
	 * @param code value to be assigned to property code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSubCode() {
		return this.subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getSubMsg() {
		return this.subMsg;
	}

	public void setSubMsg(String subMsg) {
		this.subMsg = subMsg;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public boolean isSuccess() {
		return StringUtils.isEmpty(subCode);
	}

}