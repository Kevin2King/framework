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

package com.funtl.framework.rpc.thrift.generator.builder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.funtl.framework.rpc.thrift.generator.Generic;
import com.funtl.framework.rpc.thrift.generator.ThriftEnum;
import com.funtl.framework.rpc.thrift.generator.ThriftEnumField;
import com.funtl.framework.rpc.thrift.generator.ThriftField;
import com.funtl.framework.rpc.thrift.generator.ThriftStruct;
import com.funtl.framework.rpc.thrift.generator.ThriftType;

public class ThriftStructBuilder {

	ThriftFieldBuilder thriftFieldBuilder = new ThriftFieldBuilder();

	public ThriftStruct buildThriftStruct(Class<?> clazz, List<ThriftStruct> structs, List<ThriftEnum> enums) {
		Field[] fields = clazz.getDeclaredFields();
		ThriftStruct struct = new ThriftStruct();
		List<ThriftField> thriftFields = new ArrayList<ThriftField>();
		for (Field field : fields) {
			ThriftField thriftField = thriftFieldBuilder.buildThriftField(this, field, structs, enums);
			if (thriftField == null) {
				continue;
			}
			thriftFields.add(thriftField);
		}
		struct.setName(clazz.getSimpleName());
		struct.setFields(thriftFields);
		return struct;
	}

	/**
	 * @param structs
	 * @param generic
	 */
	public void buildStrutsByGeneric(List<ThriftStruct> structs, Generic generic, List<ThriftEnum> enums) {
		List<ThriftType> thriftTypes = generic.getTypes();
		for (ThriftType subThriftType : thriftTypes) {
			if (subThriftType.isStruct()) {
				ThriftStruct subStruct = buildThriftStruct(subThriftType.getJavaClass(), structs, enums);
				structs.add(subStruct);
			}
			if (subThriftType instanceof Generic) {
				this.buildStrutsByGeneric(structs, (Generic) subThriftType, enums);
			}
		}
	}

	public ThriftEnum buildThriftEnum(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		ThriftEnum thriftEnum = new ThriftEnum();
		thriftEnum.setName(clazz.getSimpleName());

		List<ThriftEnumField> nameValues = new ArrayList<ThriftEnumField>();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			if (field.getName().equals("$VALUES") || field.getName().equals("__PARANAMER_DATA")) {
				continue;
			}
			ThriftEnumField nameValue = new ThriftEnumField(field.getName(), i);
			nameValues.add(nameValue);
		}
		thriftEnum.setFields(nameValues);
		return thriftEnum;
	}
}
