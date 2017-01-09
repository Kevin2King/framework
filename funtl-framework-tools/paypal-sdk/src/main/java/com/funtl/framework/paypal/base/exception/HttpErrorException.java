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
 * HttpErrorException denotes errors that occur in HTTP call
 */
public class HttpErrorException extends BaseException {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -4312358746964758546L;

	private int responsecode;
	private String errorResponse;

	public HttpErrorException(String msg) {
		super(msg);
	}

	public HttpErrorException(String msg, Throwable exception) {
		super(msg, exception);
	}

	public HttpErrorException(int responsecode, String errorResponse, String msg, Throwable exception) {
		super(msg, exception);
		this.responsecode = responsecode;
		this.errorResponse = errorResponse;
	}

	public int getResponsecode() {
		return responsecode;
	}

	public String getErrorResponse() {
		return errorResponse;
	}
}
