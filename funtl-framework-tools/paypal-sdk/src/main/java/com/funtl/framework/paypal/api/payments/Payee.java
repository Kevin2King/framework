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
public class Payee extends PayPalModel {

	/**
	 * Email Address associated with the Payee's PayPal Account. If the provided email address is not associated with any PayPal Account, the payee can only receive PayPal Wallet Payments. Direct Credit Card Payments will be denied due to card compliance requirements.
	 */
	private String email;

	/**
	 * Encrypted PayPal account identifier for the Payee.
	 */
	private String merchantId;

	/**
	 * First Name of the Payee.
	 */
	private String firstName;

	/**
	 * Last Name of the Payee.
	 */
	private String lastName;

	/**
	 * Unencrypted PayPal account Number of the Payee
	 */
	private String accountNumber;

	/**
	 * Information related to the Payee.
	 */
	private Phone phone;

	/**
	 * Default Constructor
	 */
	public Payee() {
	}
}
