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

import java.util.List;

import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api.AlipayApiException;

/**
 * 格式转换器。
 *
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public interface Reader {

	/**
	 * 判断返回结果是否包含指定的属性。
	 *
	 * @param name 属性名称
	 * @return true/false
	 */
	public boolean hasReturnField(Object name);

	/**
	 * 读取单个基本对象。
	 *
	 * @param name 映射名称
	 * @return 基本对象值
	 */
	public Object getPrimitiveObject(Object name);

	/**
	 * 读取单个自定义对象。
	 *
	 * @param name 映射名称
	 * @param type 映射类型
	 * @return 映射类型的实例
	 * @throws AlipayApiException
	 */
	public Object getObject(Object name, Class<?> type) throws AlipayApiException;

	/**
	 * 读取多个对象的值。
	 *
	 * @param listName 列表名称
	 * @param itemName 映射名称
	 * @param subType  嵌套映射类型
	 * @return 嵌套映射类型实例列表
	 * @throws AlipayApiException
	 */
	public List<?> getListObjects(Object listName, Object itemName, Class<?> subType) throws AlipayApiException;

}
