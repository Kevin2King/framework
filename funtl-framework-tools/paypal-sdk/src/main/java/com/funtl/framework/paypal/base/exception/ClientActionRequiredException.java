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
 * ClientActionRequiredException, encapsulates instances where client has to
 * take actions based or errors in API call.
 */
public class ClientActionRequiredException extends HttpErrorException {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -15345584654755445L;

	public ClientActionRequiredException(String message) {
		super(message);
	}

	public ClientActionRequiredException(String message, Throwable exception) {
		super(message, exception);
	}

	public ClientActionRequiredException(int responsecode, String errorResponse, String msg, Throwable exception) {
		super(responsecode, errorResponse, msg, exception);
	}

	public String toString() {
		return "HTTP response code: " + this.getResponsecode() + "\n" + "error message: " + this.getErrorResponse();
	}
}
