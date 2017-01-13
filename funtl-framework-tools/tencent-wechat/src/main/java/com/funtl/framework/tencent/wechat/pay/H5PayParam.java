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

package com.funtl.framework.tencent.wechat.pay;

import javax.xml.bind.annotation.XmlElement;

import com.funtl.framework.tencent.wechat.common.Config;

/**
 * H5调起支付API的参数对象
 * <p><a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=7_7&index=6">开发文档</p>
 * <p/>
 * Created by xuwen on 2015-12-10.
 */
public class H5PayParam {
	private String appid = Config.instance().getAppid();
	private String timeStamp;
	private String nonceStr;
	private String packageWithPrepayId; // 参数名package
	private String signType = "MD5";
	private String paySign;

	@XmlElement(name = "appId")
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	@XmlElement(name = "package")
	public String getPackageWithPrepayId() {
		return packageWithPrepayId;
	}

	public void setPackageWithPrepayId(String packageWithPrepayId) {
		this.packageWithPrepayId = packageWithPrepayId;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}

	@Override
	public String toString() {
		return "H5PayConfig{" + "appid='" + appid + '\'' + ", timeStamp='" + timeStamp + '\'' + ", nonceStr='" + nonceStr + '\'' + ", packageWithPrepayId='" + packageWithPrepayId + '\'' + ", signType='" + signType + '\'' + ", paySign='" + paySign + '\'' + '}';
	}
}
