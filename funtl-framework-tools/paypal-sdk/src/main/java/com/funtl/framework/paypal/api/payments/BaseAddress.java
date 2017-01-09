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
public class BaseAddress extends PayPalModel {

	/**
	 * Line 1 of the Address (eg. number, street, etc).
	 */
	private String line1;

	/**
	 * Optional line 2 of the Address (eg. suite, apt #, etc.).
	 */
	private String line2;

	/**
	 * City name.
	 */
	private String city;

	/**
	 * 2 letter country code.
	 */
	private String countryCode;

	/**
	 * Zip code or equivalent is usually required for countries that have them. For list of countries that do not have postal codes please refer to http://en.wikipedia.org/wiki/Postal_code.
	 */
	private String postalCode;

	/**
	 * 2 letter code for US states, and the equivalent for other countries.
	 */
	private String state;

	/**
	 * BaseAddress normalization status, returned only for payers from Brazil.
	 */
	private String normalizationStatus;

	/**
	 * BaseAddress status
	 */
	private String status;

	/**
	 * Default Constructor
	 */
	public BaseAddress() {
	}

	/**
	 * Parameterized Constructor
	 */
	public BaseAddress(String line1, String countryCode) {
		this.line1 = line1;
		this.countryCode = countryCode;
	}
}
