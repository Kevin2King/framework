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
public class CurrencyConversion extends PayPalModel {

	/**
	 * Date of validity for the conversion rate.
	 */
	private String conversionDate;

	/**
	 * 3 letter currency code
	 */
	private String fromCurrency;

	/**
	 * Amount participating in currency conversion, set to 1 as default
	 */
	private String fromAmount;

	/**
	 * 3 letter currency code
	 */
	private String toCurrency;

	/**
	 * Amount resulting from currency conversion.
	 */
	private String toAmount;

	/**
	 * Field indicating conversion type applied.
	 */
	private String conversionType;

	/**
	 * Allow Payer to change conversion type.
	 */
	private Boolean conversionTypeChangeable;

	/**
	 * Base URL to web applications endpoint
	 */
	private String webUrl;

	/**
	 *
	 */
	private List<DefinitionsLinkdescription> links;

	/**
	 * Default Constructor
	 */
	public CurrencyConversion() {
	}

	/**
	 * Parameterized Constructor
	 */
	public CurrencyConversion(String fromCurrency, String fromAmount, String toCurrency, String toAmount) {
		this.fromCurrency = fromCurrency;
		this.fromAmount = fromAmount;
		this.toCurrency = toCurrency;
		this.toAmount = toAmount;
	}
}
