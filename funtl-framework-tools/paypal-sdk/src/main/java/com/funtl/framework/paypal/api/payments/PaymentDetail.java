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
public class PaymentDetail extends PayPalModel {

	/**
	 * The PayPal payment detail. Indicates whether payment was made in an invoicing flow through PayPal or externally. In the case of the mark-as-paid API, the supported payment type is `EXTERNAL`. For backward compatibility, the `PAYPAL` payment type is still supported.
	 */
	private String type;

	/**
	 * The PayPal payment transaction ID. Required with the `PAYPAL` payment type.
	 */
	private String transactionId;

	/**
	 * Type of the transaction.
	 */
	private String transactionType;

	/**
	 * The date when the invoice was paid. The date format is *yyyy*-*MM*-*dd* *z* as defined in [Internet Date/Time Format](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String date;

	/**
	 * The payment mode or method. Required with the `EXTERNAL` payment type.
	 */
	private String method;

	/**
	 * Optional. A note associated with the payment.
	 */
	private String note;

	/**
	 * The amount to record as payment against invoice. If you omit this parameter, the total invoice amount is recorded as payment.
	 */
	private Currency amount;

	/**
	 * Default Constructor
	 */
	public PaymentDetail() {
	}

	/**
	 * Parameterized Constructor
	 */
	public PaymentDetail(String method) {
		this.method = method;
	}
}
