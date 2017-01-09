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
public class ElectronUnifiedorderResponse {
	/**
	 * 用户ID	R
	 */
	private String EBusinessID;
	/**
	 * 成功与否	R
	 */
	private boolean Success;
	/**
	 * 错误编码	R
	 */
	private String ResultCode;
	/**
	 * 失败原因	O
	 */
	private String Reason;
	/**
	 * 唯一标识	R
	 */
	private String UniquerRequestNumber;
	/**
	 * 面单打印模板	O
	 */
	private String PrintTemplate;
	/**
	 * 订单预计到货时间yyyy-mm-dd	O
	 */
	private String EstimatedDeliveryTime;
	/**
	 * 用户自定义回调信息	O
	 */
	private String Callback;

	private Order Order;

	public String getEBusinessID() {
		return EBusinessID;
	}

	public void setEBusinessID(String EBusinessID) {
		this.EBusinessID = EBusinessID;
	}

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public String getResultCode() {
		return ResultCode;
	}

	public void setResultCode(String resultCode) {
		ResultCode = resultCode;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public String getUniquerRequestNumber() {
		return UniquerRequestNumber;
	}

	public void setUniquerRequestNumber(String uniquerRequestNumber) {
		UniquerRequestNumber = uniquerRequestNumber;
	}

	public String getPrintTemplate() {
		return PrintTemplate;
	}

	public void setPrintTemplate(String printTemplate) {
		PrintTemplate = printTemplate;
	}

	public String getEstimatedDeliveryTime() {
		return EstimatedDeliveryTime;
	}

	public void setEstimatedDeliveryTime(String estimatedDeliveryTime) {
		EstimatedDeliveryTime = estimatedDeliveryTime;
	}

	public String getCallback() {
		return Callback;
	}

	public void setCallback(String callback) {
		Callback = callback;
	}

	public com.funtl.framework.track.kdniao.electron.unifiedorder.response.Order getOrder() {
		return Order;
	}

	public void setOrder(com.funtl.framework.track.kdniao.electron.unifiedorder.response.Order order) {
		Order = order;
	}
}
