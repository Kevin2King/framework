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

package com.funtl.framework.paypal.base.rest;

import com.funtl.framework.paypal.api.payments.Error;
import com.funtl.framework.paypal.base.exception.HttpErrorException;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PayPalException handles all exceptions related to REST services
 */
public class PayPalRESTException extends Exception {


	private static final Logger log = LoggerFactory.getLogger(PayPalRESTException.class);

	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * If source is {@link HttpErrorException},
	 * exception's response code value is copied
	 */
	private int responsecode;

	/**
	 * If source is {@link HttpErrorException} and response code is 400,
	 * error response content is converted to {@link Error} object
	 */
	private Error details;

	public PayPalRESTException(String message) {
		super(message);
	}

	public PayPalRESTException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public PayPalRESTException(Throwable throwable) {
		super(throwable);
	}

	public int getResponsecode() {
		return responsecode;
	}

	public void setResponsecode(int responsecode) {
		this.responsecode = responsecode;
	}

	public Error getDetails() {
		return details;
	}

	public void setDetails(Error details) {
		this.details = details;
	}

	/**
	 * Utility method that creates a {@link PayPalRESTException} object from {@link HttpErrorException}.
	 * if {@link HttpErrorException} contains 400 response code, error response is converted to {@link Error} object.
	 *
	 * @param httpErrorException {@link HttpErrorException} thrown from API call
	 * @return PayPalRESTException
	 */
	protected static PayPalRESTException createFromHttpErrorException(HttpErrorException httpErrorException) {
		PayPalRESTException ppre = new PayPalRESTException(httpErrorException.getMessage(), httpErrorException);
		ppre.setResponsecode(httpErrorException.getResponsecode());
		if (httpErrorException.getResponsecode() >= 400 && httpErrorException.getErrorResponse() != null && isJSONValid(httpErrorException.getErrorResponse())) {
			try {
				Error details = JSONFormatter.fromJSON(httpErrorException.getErrorResponse(), Error.class);
				ppre.setDetails(details);
			} catch (Exception e) {
				log.error("Exception thrown while parsing error response: " + httpErrorException.getErrorResponse(), e);
			}
		}
		return ppre;
	}

	public String toString() {
		return "response-code: " + this.responsecode + "\tdetails: " + this.details;
	}

	private static boolean isJSONValid(String jsonInString) {
		try {
			new Gson().fromJson(jsonInString, Object.class);
			return true;
		} catch (com.google.gson.JsonSyntaxException ex) {
			return false;
		}
	}

}
