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

package com.funtl.framework.alipay.trade.pay.protocol.downloadbill.request;

import java.util.Map;

import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api.AlipayRequest;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.internal.util.AlipayHashMap;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.response.AlipayDataDataserviceBillDownloadurlQueryResponse;

/**
 * ALIPAY API: alipay.data.dataservice.bill.downloadurl.query request
 *
 * @author auto create
 * @since 1.0, 2016-04-15 09:22:23
 */
public class AlipayDataDataserviceBillDownloadurlQueryRequest implements AlipayRequest<AlipayDataDataserviceBillDownloadurlQueryResponse> {

	private AlipayHashMap udfParams; // add user-defined text parameters
	private String apiVersion = "1.0";

	/**
	 * 无授权模式的查询对账单下载地址
	 */
	private String bizContent;

	public void setBizContent(String bizContent) {
		this.bizContent = bizContent;
	}

	public String getBizContent() {
		return this.bizContent;
	}

	private String terminalType;
	private String terminalInfo;
	private String prodCode;
	private String notifyUrl;

	public String getNotifyUrl() {
		return this.notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getApiVersion() {
		return this.apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getTerminalType() {
		return this.terminalType;
	}

	public void setTerminalInfo(String terminalInfo) {
		this.terminalInfo = terminalInfo;
	}

	public String getTerminalInfo() {
		return this.terminalInfo;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getProdCode() {
		return this.prodCode;
	}

	public String getApiMethodName() {
		return "alipay.data.dataservice.bill.downloadurl.query";
	}

	public Map<String, String> getTextParams() {
		AlipayHashMap txtParams = new AlipayHashMap();
		txtParams.put("biz_content", this.bizContent);
		if (udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public void putOtherTextParam(String key, String value) {
		if (this.udfParams == null) {
			this.udfParams = new AlipayHashMap();
		}
		this.udfParams.put(key, value);
	}

	public Class<AlipayDataDataserviceBillDownloadurlQueryResponse> getResponseClass() {
		return AlipayDataDataserviceBillDownloadurlQueryResponse.class;
	}
}
