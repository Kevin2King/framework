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
public class PaymentCardToken extends PayPalModel {

	/**
	 * ID of a previously saved Payment Card resource.
	 */
	private String paymentCardId;

	/**
	 * The unique identifier of the payer used when saving this payment card.
	 */
	private String externalCustomerId;

	/**
	 * Last 4 digits of the card number from the saved card.
	 */
	private String last4;

	/**
	 * Type of the Card.
	 */
	private String type;

	/**
	 * card expiry month from the saved card with value 1 - 12
	 */
	private int expireMonth;

	/**
	 * 4 digit card expiry year from the saved card
	 */
	private int expireYear;

	/**
	 * Default Constructor
	 */
	public PaymentCardToken() {
	}

	/**
	 * Parameterized Constructor
	 */
	public PaymentCardToken(String paymentCardId, String externalCustomerId, String type) {
		this.paymentCardId = paymentCardId;
		this.externalCustomerId = externalCustomerId;
		this.type = type;
	}
}
