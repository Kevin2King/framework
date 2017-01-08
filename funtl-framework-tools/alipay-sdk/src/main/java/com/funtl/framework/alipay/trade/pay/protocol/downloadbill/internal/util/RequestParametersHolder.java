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

package com.funtl.framework.alipay.trade.pay.protocol.downloadbill.internal.util;

public class RequestParametersHolder {
	private AlipayHashMap protocalMustParams;
	private AlipayHashMap protocalOptParams;
	private AlipayHashMap applicationParams;

	public AlipayHashMap getProtocalMustParams() {
		return protocalMustParams;
	}

	public void setProtocalMustParams(AlipayHashMap protocalMustParams) {
		this.protocalMustParams = protocalMustParams;
	}

	public AlipayHashMap getProtocalOptParams() {
		return protocalOptParams;
	}

	public void setProtocalOptParams(AlipayHashMap protocalOptParams) {
		this.protocalOptParams = protocalOptParams;
	}

	public AlipayHashMap getApplicationParams() {
		return applicationParams;
	}

	public void setApplicationParams(AlipayHashMap applicationParams) {
		this.applicationParams = applicationParams;
	}

}
