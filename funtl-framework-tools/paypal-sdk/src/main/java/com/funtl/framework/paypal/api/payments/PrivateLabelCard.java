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
public class PrivateLabelCard extends PayPalModel {

	/**
	 * encrypted identifier of the private label card instrument.
	 */
	private String id;

	/**
	 * last 4 digits of the card number.
	 */
	private String cardNumber;

	/**
	 * Merchants providing private label store cards have associated issuer account. This value indicates encrypted account number of the associated issuer account.
	 */
	private String issuerId;

	/**
	 * Merchants providing private label store cards have associated issuer account. This value indicates name on the issuer account.
	 */
	private String issuerName;

	/**
	 * This value indicates URL to access PLCC program logo image
	 */
	private String imageKey;

	/**
	 * Default Constructor
	 */
	public PrivateLabelCard() {
	}

}
