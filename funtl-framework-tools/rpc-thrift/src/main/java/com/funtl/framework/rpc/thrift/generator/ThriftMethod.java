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

import java.util.List;

/**
 * @author hongliuliao
 *         <p>
 *         createTime:2012-11-23 上午11:59:37
 */
public class ThriftMethod {

	private Generic returnGenericType;

	private String name;

	private List<ThriftMethodArg> methodArgs;

	private List<Class<?>> relationClasses;

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
	 * @return the args
	 */
	public List<ThriftMethodArg> getMethodArgs() {
		return methodArgs;
	}

	/**
	 * @param args the args to set
	 */
	public void setMethodArgs(List<ThriftMethodArg> args) {
		this.methodArgs = args;
	}

	/**
	 * @return the relationClasses
	 */
	public List<Class<?>> getRelationClasses() {
		return relationClasses;
	}

	/**
	 * @param relationClasses the relationClasses to set
	 */
	public void setRelationClasses(List<Class<?>> relationClasses) {
		this.relationClasses = relationClasses;
	}

	/**
	 * @return the returnGeneric
	 */
	public Generic getReturnGenericType() {
		return returnGenericType;
	}

	/**
	 * @param returnGeneric the returnGeneric to set
	 */
	public void setReturnGenericType(Generic returnGeneric) {
		this.returnGenericType = returnGeneric;
	}

}
