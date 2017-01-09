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

package com.funtl.framework.track.kdniao.distinguish.response;


import java.util.List;

/**
 * Created by 金勇 on 2016-12-02.
 * 因为返回的JSON 的 Key 的首字母为大写字母，所以以下的属性 首字母也是大写，方便解析
 */
public class DistinguishUnifiedorderResponse {
	/**
	 * 电商用户ID	R
	 */
	private String EBusinessID;
	/**
	 * 物流单号	R
	 */
	private String LogisticCode;
	/**
	 * 成功与否	R
	 */
	private boolean Success;
	/**
	 * 失败原因	O
	 */
	private Integer Code;
	/**
	 * 快递公司
	 */
	private List<Shipper> Shippers;

	public String getEBusinessID() {
		return EBusinessID;
	}

	public void setEBusinessID(String EBusinessID) {
		this.EBusinessID = EBusinessID;
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

	public Integer getCode() {
		return Code;
	}

	public void setCode(Integer code) {
		Code = code;
	}

	public List<Shipper> getShippers() {
		return Shippers;
	}

	public void setShippers(List<Shipper> shippers) {
		Shippers = shippers;
	}
}
