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

package com.funtl.framework.track.kdniao.common;

/**
 * Created by 金勇 on 2016-12-02.
 */
public class ApiContext {
	public static final String REQUEST_TYPE_QUERY = "1002";
	public static final String REQUEST_TYPE_DISTINGUISH = "2002";
	public static final String REQUEST_TYPE_ELECTRON = "1007";

	/**
	 * 请求内容需进行URL(utf-8)编码。请求内容JSON格式，须和DataType一致。	R
	 */
	private String requestData;
	/**
	 * 商户ID，请在我的服务页面查看。	R
	 */
	private String eBusinessID;
	/**
	 * 请求指令类型：1007	R
	 */
	private String requestType; //
	/**
	 * 数据内容签名：把(请求内容(未编码)+AppKey)进行MD5加密，然后Base64编码，最后 进行URL(utf-8)编码。详细过程请查看Demo。	R
	 */
	private String dataSign;
	/**
	 * 请求、返回数据类型：只支持JSON格式
	 */
	private String dataType;

	public String getRequestData() {
		return requestData;
	}

	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}

	public String geteBusinessID() {
		return eBusinessID;
	}

	public void seteBusinessID(String eBusinessID) {
		this.eBusinessID = eBusinessID;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getDataSign() {
		return dataSign;
	}

	public void setDataSign(String dataSign) {
		this.dataSign = dataSign;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
}
