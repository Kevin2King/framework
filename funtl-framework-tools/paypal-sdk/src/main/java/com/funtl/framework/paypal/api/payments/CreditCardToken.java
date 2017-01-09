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
public class CreditCardToken extends PayPalModel {

	/**
	 * ID of credit card previously stored using `/vault/credit-card`.
	 */
	private String creditCardId;

	/**
	 * A unique identifier that you can assign and track when storing a credit card or using a stored credit card. This ID can help to avoid unintentional use or misuse of credit cards. This ID can be any value you would like to associate with the saved card, such as a UUID, username, or email address.  **Required when using a stored credit card if a payer_id was originally provided when storing the credit card in vault.**
	 */
	private String payerId;

	/**
	 * Last four digits of the stored credit card number.
	 */
	private String last4;

	/**
	 * Credit card type. Valid types are: `visa`, `mastercard`, `discover`, `amex`. Values are presented in lowercase and not should not be used for display.
	 */
	private String type;

	/**
	 * Expiration month with no leading zero. Acceptable values are 1 through 12.
	 */
	private int expireMonth;

	/**
	 * 4-digit expiration year.
	 */
	private int expireYear;

	/**
	 * Default Constructor
	 */
	public CreditCardToken() {
	}

	/**
	 * Parameterized Constructor
	 */
	public CreditCardToken(String creditCardId) {
		this.creditCardId = creditCardId;
	}
}
