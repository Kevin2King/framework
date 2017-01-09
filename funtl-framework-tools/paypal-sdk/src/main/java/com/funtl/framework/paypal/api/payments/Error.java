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

import java.util.List;

import com.funtl.framework.paypal.base.rest.PayPalModel;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Error extends PayPalModel {

	/**
	 * Human readable, unique name of the error.
	 */
	private String name;

	/**
	 * Message describing the error.
	 */
	private String message;

	/**
	 * Additional details of the error
	 */
	private List<ErrorDetails> details;

	/**
	 * URI for detailed information related to this error for the developer.
	 */
	private String informationLink;

	/**
	 * PayPal internal identifier used for correlation purposes.
	 */
	private String debugId;

	/**
	 * Links
	 */
	private List<DefinitionsLinkdescription> links;

	/**
	 * @deprecated This property is not available publicly
	 * PayPal internal error code.
	 */
	@Deprecated
	private String code;

	/**
	 * @deprecated This property is not available publicly
	 * Fraud filter details.  Only supported when the `payment_method` is set to `credit_card`
	 */
	@Deprecated
	private FmfDetails fmfDetails;

	/**
	 * @deprecated This property is not available publicly
	 * response codes returned from a payment processor such as avs, cvv, etc. Only supported when the `payment_method` is set to `credit_card`.
	 */
	@Deprecated
	private ProcessorResponse processorResponse;

	/**
	 * @deprecated This property is not available publicly
	 * Reference ID of the purchase_unit associated with this error
	 */
	@Deprecated()
	private String purchaseUnitReferenceId;

	/**
	 * Default Constructor
	 */
	public Error() {
	}

	/**
	 * Parameterized Constructor
	 */
	public Error(String name, String message, String informationLink, String debugId) {
		this.name = name;
		this.message = message;
		this.informationLink = informationLink;
		this.debugId = debugId;
	}

	public String toString() {
		return "name: " + this.name + "\tmessage: " + this.message + "\tdetails: " + this.details + "\tdebug-id: " + this.debugId + "\tinformation-link: " + this.informationLink;
	}
}
