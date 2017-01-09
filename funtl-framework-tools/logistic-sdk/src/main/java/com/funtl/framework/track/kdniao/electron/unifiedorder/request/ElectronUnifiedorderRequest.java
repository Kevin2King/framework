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

package com.funtl.framework.track.kdniao.electron.unifiedorder.request;

import java.util.List;

/**
 * Created by 金勇 on 2016-12-02.
 * 备注：R-必填（Required），O-可选（Optional），C-报文中该参数在一定条件下可选（Conditional）
 */
public class ElectronUnifiedorderRequest {
	/**
	 * 用户自定义回调信息	O
	 */
	private String callBack;
	/**
	 * 会员标识	O
	 */
	private String memberID;
	/**
	 * 电子面单客户账号（与快递网点申请）	O
	 */
	private String customerName;
	/**
	 * 电子面单密码	O
	 */
	private String customerPwd;
	/**
	 * 收件网点标识	O
	 */
	private String sendSite;
	/**
	 * 快递公司编码	R
	 */
	private String shipperCode;
	/**
	 * 快递单号	O
	 */
	private String logisticCode;
	/**
	 * 订单编号	R
	 */
	private String orderCode;
	/**
	 * 月结编码	C
	 */
	private String monthCode;
	/**
	 * 邮费支付方式:1-现付，2-到付，3-月结，4-第三方支付	R
	 */
	private Integer payType;
	/**
	 * 快递类型：1-标准快件	R
	 */
	private String expType;
	/**
	 * 是否通知快递员上门揽件：0-通知；1-不通知；不填则默认为0	O
	 */
	private Integer isNotice;
	/**
	 * 寄件费（运费）	O
	 */
	private Double cost;
	/**
	 * 其他费用	O
	 */
	private Double otherCost;
	/**
	 * 上门取货时间段:"yyyy-MM-dd HH:mm:ss"格式化，本文中所有时间格式相同	O
	 */
	private String startDate;
	/**
	 * O
	 */
	private String endDate;
	/**
	 * 物品总重量kg	O
	 */
	private Double weight;
	/**
	 * 件数/包裹数	O
	 */
	private Integer quantity;
	/**
	 * 物品总体积m3	O
	 */
	private Double volume;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 返回电子面单模板：0-不需要；1-需要	O
	 */
	private String isReturnPrintTemplate;

	private Receiver receiver;

	private Sender sender;

	private List<AddService> addServices;

	private List<Commodity> commodity;

	public String getCallBack() {
		return callBack;
	}

	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPwd() {
		return customerPwd;
	}

	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}

	public String getSendSite() {
		return sendSite;
	}

	public void setSendSite(String sendSite) {
		this.sendSite = sendSite;
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

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getMonthCode() {
		return monthCode;
	}

	public void setMonthCode(String monthCode) {
		this.monthCode = monthCode;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getExpType() {
		return expType;
	}

	public void setExpType(String expType) {
		this.expType = expType;
	}

	public Integer getIsNotice() {
		return isNotice;
	}

	public void setIsNotice(Integer isNotice) {
		this.isNotice = isNotice;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getOtherCost() {
		return otherCost;
	}

	public void setOtherCost(Double otherCost) {
		this.otherCost = otherCost;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsReturnPrintTemplate() {
		return isReturnPrintTemplate;
	}

	public void setIsReturnPrintTemplate(String isReturnPrintTemplate) {
		this.isReturnPrintTemplate = isReturnPrintTemplate;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public Sender getSender() {
		return sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public List<AddService> getAddServices() {
		return addServices;
	}

	public void setAddServices(List<AddService> addServices) {
		this.addServices = addServices;
	}

	public List<Commodity> getCommodity() {
		return commodity;
	}

	public void setCommodity(List<Commodity> commodity) {
		this.commodity = commodity;
	}
}
