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

/**
 * Created by 金勇 on 2016-12-02.
 */
public class Sender {
	/**
	 * 发件人公司	O
	 */
	private String company;
	/**
	 * 发件人	R
	 */
	private String name;
	/**
	 * 电话与手机，必填一个	R
	 */
	private String tel;
	/**
	 * 电话与手机，必填一个	R
	 */
	private String mobile;
	/**
	 * 发件人邮编	O
	 */
	private String postCode;
	/**
	 * 发件省（如广东省，不要缺少“省”）	R
	 */
	private String provinceName;
	/**
	 * 发件市（如深圳市，不要缺少“市”）	R
	 */
	private String cityName;
	/**
	 * 发件区（如福田区，不要缺少“区”或“县”）	O
	 */
	private String expAreaName;
	/**
	 * 发件人详细地址	R
	 */
	private String address;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getExpAreaName() {
		return expAreaName;
	}

	public void setExpAreaName(String expAreaName) {
		this.expAreaName = expAreaName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
