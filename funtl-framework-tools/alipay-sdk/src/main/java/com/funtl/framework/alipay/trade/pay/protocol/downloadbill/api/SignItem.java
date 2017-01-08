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

package com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api;

import java.io.Serializable;

/**
 * 签名类型
 *
 * @author jie.hua
 * @version $Id: SignItem.java, v 0.1 2015-4-21 下午2:11:37 jiehua Exp $
 */
public class SignItem implements Serializable {

	/**  */
	private static final long serialVersionUID = 6531196726066096786L;

	/**
	 * 签名源串
	 */
	private String signSourceDate;

	/**
	 * 签名
	 */
	private String sign;

	/**
	 * Getter method for property <tt>signSourceDate</tt>.
	 *
	 * @return property value of signSourceDate
	 */
	public String getSignSourceDate() {
		return signSourceDate;
	}

	/**
	 * Setter method for property <tt>signSourceDate</tt>.
	 *
	 * @param signSourceDate value to be assigned to property signSourceDate
	 */
	public void setSignSourceDate(String signSourceDate) {
		this.signSourceDate = signSourceDate;
	}

	/**
	 * Getter method for property <tt>sign</tt>.
	 *
	 * @return property value of sign
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * Setter method for property <tt>sign</tt>.
	 *
	 * @param sign value to be assigned to property sign
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

}
