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
public class MerchantPreferences extends PayPalModel {

	/**
	 * Identifier of the merchant_preferences. 128 characters max.
	 */
	private String id;

	/**
	 * Setup fee amount. Default is 0.
	 */
	private Currency setupFee;

	/**
	 * Redirect URL on cancellation of agreement request. 1000 characters max.
	 */
	private String cancelUrl;

	/**
	 * Redirect URL on creation of agreement request. 1000 characters max.
	 */
	private String returnUrl;

	/**
	 * Notify URL on agreement creation. 1000 characters max.
	 */
	private String notifyUrl;

	/**
	 * Total number of failed attempts allowed. Default is 0, representing an infinite number of failed attempts.
	 */
	private String maxFailAttempts;

	/**
	 * Allow auto billing for the outstanding amount of the agreement in the next cycle. Allowed values: `YES`, `NO`. Default is `NO`.
	 */
	private String autoBillAmount;

	/**
	 * Action to take if a failure occurs during initial payment. Allowed values: `CONTINUE`, `CANCEL`. Default is continue.
	 */
	private String initialFailAmountAction;

	/**
	 * Payment types that are accepted for this plan.
	 */
	private String acceptedPaymentType;

	/**
	 * char_set for this plan.
	 */
	private String charSet;

	/**
	 * Default Constructor
	 */
	public MerchantPreferences() {
	}

	/**
	 * Parameterized Constructor
	 */
	public MerchantPreferences(String cancelUrl, String returnUrl) {
		this.cancelUrl = cancelUrl;
		this.returnUrl = returnUrl;
	}
}
