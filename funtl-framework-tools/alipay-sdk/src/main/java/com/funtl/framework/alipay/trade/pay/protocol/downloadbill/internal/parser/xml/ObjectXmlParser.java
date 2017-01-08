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

package com.funtl.framework.alipay.trade.pay.protocol.downloadbill.internal.parser.xml;

import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api.AlipayApiException;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api.AlipayParser;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api.AlipayRequest;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api.AlipayResponse;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api.SignItem;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.internal.mapping.Converter;

/**
 * 单个JSON对象解释器。
 *
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public class ObjectXmlParser<T extends AlipayResponse> implements AlipayParser<T> {

	private Class<T> clazz;

	public ObjectXmlParser(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T parse(String rsp) throws AlipayApiException {
		Converter converter = new XmlConverter();
		return converter.toResponse(rsp, clazz);
	}

	public Class<T> getResponseClass() {
		return clazz;
	}

	public SignItem getSignItem(AlipayRequest<?> request, AlipayResponse response) throws AlipayApiException {

		Converter converter = new XmlConverter();

		return converter.getSignItem(request, response);
	}

}
