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

package com.funtl.framework.track.kdniao.query.unifiedorder.request;

/**
 * Created by 金勇 on 2016-12-02.
 * 因为返回的JSON 的 Key 的首字母为大写字母，所以以下的属性 首字母也是大写，方便解析
 */
public class QueryUnifiedorderRequest {
	/**
	 * 订单编号	O
	 */
	private String orderCode;
	/**
	 * 快递公司编码	R
	 */
	private String shipperCode;
	/**
	 * 物流单号	R
	 */
	private String logisticCode;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getShipperCode() {
		return shipperCode;
	}

	public void setShipperCode(String shipperCode) {
		this.shipperCode = shipperCode;
	}

	public String getLogisticCode() {
		return logisticCode;
	}

	public void setLogisticCode(String logisticCode) {
		this.logisticCode = logisticCode;
	}
}
