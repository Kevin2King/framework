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

import java.util.Map;

/**
 * 上传请求接口，支持同时上传多个文件。
 *
 * @author carver.gu
 * @since 1.0, Sep 12, 2009
 */
public interface AlipayUploadRequest<T extends AlipayResponse> extends AlipayRequest<T> {

	/**
	 * 获取所有的Key-Value形式的文件请求参数集合。其中：
	 * <ul>
	 * <li>Key: 请求参数名</li>
	 * <li>Value: 请求参数文件元数据</li>
	 * </ul>
	 *
	 * @return 文件请求参数集合
	 */
	public Map<String, FileItem> getFileParams();

}
