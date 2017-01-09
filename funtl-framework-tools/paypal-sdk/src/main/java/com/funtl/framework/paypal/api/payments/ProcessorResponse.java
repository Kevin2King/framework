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

package com.funtl.framework.paypal.api.payments;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import com.funtl.framework.paypal.base.rest.PayPalModel;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ProcessorResponse extends PayPalModel {

	/**
	 * Paypal normalized response code, generated from the processor's specific response code
	 */
	private String responseCode;

	/**
	 * Address Verification System response code. https://developer.paypal.com/webapps/developer/docs/classic/api/AVSResponseCodes/
	 */
	private String avsCode;

	/**
	 * CVV System response code. https://developer.paypal.com/webapps/developer/docs/classic/api/AVSResponseCodes/
	 */
	private String cvvCode;

	/**
	 * Provides merchant advice on how to handle declines related to recurring payments
	 */
	private String adviceCode;

	/**
	 * Response back from the authorization. Provided by the processor
	 */
	private String eciSubmitted;

	/**
	 * Visa Payer Authentication Service status. Will be return from processor
	 */
	private String vpas;

	/**
	 * Default Constructor
	 */
	public ProcessorResponse() {
	}

	/**
	 * Parameterized Constructor
	 */
	public ProcessorResponse(String responseCode) {
		this.responseCode = responseCode;
	}
}
