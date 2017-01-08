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

package com.funtl.framework.alipay.trade.pay.protocol.downloadbill.internal.mapping;

import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api.AlipayApiException;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api.AlipayRequest;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api.AlipayResponse;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api.SignItem;

/**
 * 动态格式转换器。
 *
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public interface Converter {

	/**
	 * 把字符串转换为响应对象。
	 *
	 * @param <T>   领域泛型
	 * @param rsp   响应字符串
	 * @param clazz 领域类型
	 * @return 响应对象
	 * @throws AlipayApiException
	 */
	public <T extends AlipayResponse> T toResponse(String rsp, Class<T> clazz) throws AlipayApiException;

	/**
	 * 获取响应内的签名数据
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws AlipayApiException
	 */
	public SignItem getSignItem(AlipayRequest<?> request, AlipayResponse response) throws AlipayApiException;

}
