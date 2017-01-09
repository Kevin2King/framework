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

package com.funtl.framework.track.kdniao.query.unifiedorder.response;

/**
 * Created by 金勇 on 2016-12-02.
 * 因为返回的JSON 的 Key 的首字母为大写字母，所以以下的属性 首字母也是大写，方便解析
 */
public class QueryUnifiedorderResponse {
	/**
	 * 用户ID	R
	 */
	private String EBusinessID;
	/**
	 * 订单编号	O
	 */
	private String OrderCode;
	/**
	 * 快递公司编码	R
	 */
	private String ShipperCode;
	/**
	 * 物流运单号	O
	 */
	private String LogisticCode;
	/**
	 * 成功与否	R
	 */
	private boolean Success;
	/**
	 * 失败原因	O
	 */
	private String Reason;
	/**
	 * 物流状态：2-在途中,3-签收,4-问题件	R
	 */
	private String State;
	private String Traces;
	/**
	 * 时间	R
	 */
	private String AcceptTime;
	/**
	 * 描述	R
	 */
	private String AcceptStation;
	/**
	 * 备注	O
	 */
	private String Remark;

	public String getEBusinessID() {
		return EBusinessID;
	}

	public void setEBusinessID(String EBusinessID) {
		this.EBusinessID = EBusinessID;
	}

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

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getTraces() {
		return Traces;
	}

	public void setTraces(String traces) {
		Traces = traces;
	}

	public String getAcceptTime() {
		return AcceptTime;
	}

	public void setAcceptTime(String acceptTime) {
		AcceptTime = acceptTime;
	}

	public String getAcceptStation() {
		return AcceptStation;
	}

	public void setAcceptStation(String acceptStation) {
		AcceptStation = acceptStation;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}
}
