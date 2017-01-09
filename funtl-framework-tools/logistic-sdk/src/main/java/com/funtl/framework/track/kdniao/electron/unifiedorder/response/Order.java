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

package com.funtl.framework.track.kdniao.electron.unifiedorder.response;

/**
 * Created by 金勇 on 2016-12-02.
 * 因为返回的JSON 的 Key 的首字母为大写字母，所以以下的属性 首字母也是大写，方便解析
 */
public class Order {
	/**
	 * 订单编号	R
	 */
	private String OrderCode;
	/**
	 * 快递公司编码	R
	 */
	private String ShipperCode;
	/**
	 * 快递单号	R
	 */
	private String LogisticCode;
	/**
	 * 大头笔	O
	 */
	private String MarkDestination;
	/**
	 * 始发地区域编码	O
	 */
	private String OriginCode;
	/**
	 * 始发地/始发网点	O
	 */
	private String OriginName;
	/**
	 * 目的地区域编码	O
	 */
	private String DestinatioCode;
	/**
	 * 目的地/到达网点	O
	 */
	private String DestinatioName;
	/**
	 * 分拣编码	O
	 */
	private String SortingCode;
	/**
	 * 集包编码	O
	 */
	private String PackageCode;

	public String getOrderCode() {
		return OrderCode;
	}

	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}

	public String getShipperCode() {
		return ShipperCode;
	}

	public void setShipperCode(String shipperCode) {
		ShipperCode = shipperCode;
	}

	public String getLogisticCode() {
		return LogisticCode;
	}

	public void setLogisticCode(String logisticCode) {
		LogisticCode = logisticCode;
	}

	public String getMarkDestination() {
		return MarkDestination;
	}

	public void setMarkDestination(String markDestination) {
		MarkDestination = markDestination;
	}

	public String getOriginCode() {
		return OriginCode;
	}

	public void setOriginCode(String originCode) {
		OriginCode = originCode;
	}

	public String getOriginName() {
		return OriginName;
	}

	public void setOriginName(String originName) {
		OriginName = originName;
	}

	public String getDestinatioCode() {
		return DestinatioCode;
	}

	public void setDestinatioCode(String destinatioCode) {
		DestinatioCode = destinatioCode;
	}

	public String getDestinatioName() {
		return DestinatioName;
	}

	public void setDestinatioName(String destinatioName) {
		DestinatioName = destinatioName;
	}

	public String getSortingCode() {
		return SortingCode;
	}

	public void setSortingCode(String sortingCode) {
		SortingCode = sortingCode;
	}

	public String getPackageCode() {
		return PackageCode;
	}

	public void setPackageCode(String packageCode) {
		PackageCode = packageCode;
	}
}
