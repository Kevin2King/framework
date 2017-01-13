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

package com.funtl.framework.rpc.thrift.generator;

import java.lang.reflect.Type;

/**
 * @author hongliuliao
 *         <p>
 *         createTime:2012-11-23 下午2:45:25
 */
public class ThriftMethodArg {

	private Generic genericType;

	private String name;

	/**
	 *
	 */
	public ThriftMethodArg() {

	}

	public ThriftMethodArg(Type type, String paramName) {
		this.name = paramName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the generic
	 */
	public Generic getGenericType() {
		return genericType;
	}

	/**
	 * @param generic the generic to set
	 */
	public void setGenericType(Generic generic) {
		this.genericType = generic;
	}


}
