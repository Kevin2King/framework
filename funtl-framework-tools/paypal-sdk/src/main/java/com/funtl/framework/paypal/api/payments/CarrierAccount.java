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
public class CarrierAccount extends PayPalModel {

	/**
	 * The ID of the carrier account of the payer. Use in subsequent REST API calls. For example, to make payments.
	 */
	private String id;

	/**
	 * The phone number of the payer, in E.164 format.
	 */
	private String phoneNumber;

	/**
	 * The ID of the customer, as created by the merchant.
	 */
	private String externalCustomerId;

	/**
	 * The method used to obtain the phone number. Value is `READ_FROM_DEVICE` or `USER_PROVIDED`.
	 */
	private String phoneSource;

	/**
	 * The ISO 3166-1 alpha-2 country code where the phone number is registered.
	 */
	private CountryCode countryCode;

	/**
	 * Default Constructor
	 */
	public CarrierAccount() {
	}

	/**
	 * Parameterized Constructor
	 */
	public CarrierAccount(String externalCustomerId, CountryCode countryCode) {
		this.externalCustomerId = externalCustomerId;
		this.countryCode = countryCode;
	}
}
