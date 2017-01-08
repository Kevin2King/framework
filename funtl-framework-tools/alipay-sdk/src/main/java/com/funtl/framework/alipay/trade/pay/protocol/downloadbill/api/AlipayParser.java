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

/**
 * 响应解释器接口。响应格式可以是JSON, XML等等。
 *
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public interface AlipayParser<T extends AlipayResponse> {

	/**
	 * 把响应字符串解释成相应的领域对象。
	 *
	 * @param rsp 响应字符串
	 * @return 领域对象
	 */
	public T parse(String rsp) throws AlipayApiException;

	/**
	 * 获取响应类类型。
	 */
	public Class<T> getResponseClass() throws AlipayApiException;

	/**
	 * 获取响应内的签名数据
	 *
	 * @param request 请求字符串
	 * @param response 响应字符串
	 * @return
	 * @throws AlipayApiException
	 */
	public SignItem getSignItem(AlipayRequest<?> request, AlipayResponse response) throws AlipayApiException;

}
