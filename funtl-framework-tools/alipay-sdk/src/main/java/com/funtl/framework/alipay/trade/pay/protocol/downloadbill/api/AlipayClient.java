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
 * @author runzhi
 */
public interface AlipayClient {

	/**
	 * @param <T>
	 * @param request
	 * @return
	 * @throws AlipayApiException
	 */
	public <T extends AlipayResponse> T execute(AlipayRequest<T> request) throws AlipayApiException;

	/**
	 * @param <T>
	 * @param request
	 * @param authToken
	 * @return
	 * @throws AlipayApiException
	 */
	public <T extends AlipayResponse> T execute(AlipayRequest<T> request, String authToken) throws AlipayApiException;


}
