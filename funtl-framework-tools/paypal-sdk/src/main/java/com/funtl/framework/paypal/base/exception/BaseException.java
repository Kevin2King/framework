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

package com.funtl.framework.paypal.base.exception;

/**
 * BaseException for SDK
 */
public class BaseException extends Exception {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -5345825923487658213L;

	public BaseException(String msg) {
		super(msg);
	}

	public BaseException(String msg, Throwable exception) {
		super(msg, exception);
	}

}
