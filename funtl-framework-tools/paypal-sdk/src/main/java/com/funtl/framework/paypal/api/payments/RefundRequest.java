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
public class RefundRequest extends PayPalModel {

	/**
	 * Details including both refunded amount (to payer) and refunded fee (to payee).
	 */
	private Amount amount;

	/**
	 * Description of what is being refunded for. Character length and limitations: 255 single-byte alphanumeric characters.
	 */
	private String description;

	/**
	 * Type of refund you are making.
	 */
	private String refundType;

	/**
	 * Type of PayPal funding source (balance or eCheck) that can be used for auto refund.
	 */
	private String refundSource;

	/**
	 * Reason description for the Sale transaction being refunded.
	 */
	private String reason;

	/**
	 * The invoice number that is used to track this payment. Character length and limitations: 127 single-byte alphanumeric characters.
	 */
	private String invoiceNumber;

	/**
	 * Flag to indicate that the buyer was already given store credit for a given transaction.
	 */
	private Boolean refundAdvice;

	/**
	 * It indicates that the resource id passed is not processed by payments platform
	 */
	private String isNonPlatformTransaction;

	/**
	 * Default Constructor
	 */
	public RefundRequest() {
	}

}
