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

package com.funtl.framework.alipay.trade.pay.protocol.downloadbill.response;

import java.util.List;

import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api.AlipayResponse;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.data.dataservice.bill.downloadurl.query response.
 *
 * @author auto create
 * @since 1.0, 2016-04-15 09:22:23
 */
public class AlipayDataDataserviceBillDownloadurlQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 3294325729477111782L;

	/**
	 * 账单下载地址链接，获取连接后30秒后未下载，链接地址失效。
	 */
	@ApiField("bill_download_url")
	private String billDownloadUrl;
	/**
	 * 对账单列表数据
	 */
	private List<String> billDataList;
	/**
	 * 对账单汇总数据
	 */
	private List<String> billCountDataList;

	public void setBillDownloadUrl(String billDownloadUrl) {
		this.billDownloadUrl = billDownloadUrl;
	}

	public String getBillDownloadUrl() {
		return this.billDownloadUrl;
	}

	public List<String> getBillCountDataList() {
		return billCountDataList;
	}

	public void setBillCountDataList(List<String> billCountDataList) {
		this.billCountDataList = billCountDataList;
	}

	public List<String> getBillDataList() {
		return billDataList;
	}

	public void setBillDataList(List<String> billDataList) {
		this.billDataList = billDataList;
	}
}