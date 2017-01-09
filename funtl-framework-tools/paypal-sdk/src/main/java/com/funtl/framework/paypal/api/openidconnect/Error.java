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

package com.funtl.framework.paypal.api.openidconnect;

import com.funtl.framework.paypal.base.rest.PayPalModel;

public class Error extends PayPalModel {

	/**
	 * A single ASCII error code from the following enum.
	 */
	private String error;

	/**
	 * A resource ID that indicates the starting resource in the returned results.
	 */
	private String errorDescription;

	/**
	 * A URI identifying a human-readable web page with information about the error, used to provide the client developer with additional information about the error.
	 */
	private String errorUri;

	/**
	 * Default Constructor
	 */
	public Error() {
	}

	/**
	 * Parameterized Constructor
	 */
	public Error(String error) {
		this.error = error;
	}

	/**
	 * Setter for error
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * Getter for error
	 */
	public String getError() {
		return this.error;
	}

	/**
	 * Setter for errorDescription
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	/**
	 * Getter for errorDescription
	 */
	public String getErrorDescription() {
		return this.errorDescription;
	}

	/**
	 * Setter for errorUri
	 */
	public void setErrorUri(String errorUri) {
		this.errorUri = errorUri;
	}

	/**
	 * Getter for errorUri
	 */
	public String getErrorUri() {
		return this.errorUri;
	}

}
