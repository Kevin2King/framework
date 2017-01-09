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
public class RefundDetail extends PayPalModel {

	/**
	 * The PayPal refund type. Indicates whether refund was paid in invoicing flow through PayPal or externally. In the case of mark-as-refunded API, the supported refund type is `EXTERNAL`. For backward compatability, the `PAYPAL` refund type is still supported.
	 */
	private String type;

	/**
	 * The PayPal refund transaction ID. Required with the `PAYPAL` refund type.
	 */
	private String transactionId;

	/**
	 * Date on which the invoice was refunded. Date format: yyyy-MM-dd z. For example, 2014-02-27 PST.
	 */
	private String date;

	/**
	 * Optional note associated with the refund.
	 */
	private String note;

	/**
	 * Amount to be recorded as refund against invoice. If this field is not passed, the total invoice paid amount is recorded as refund.
	 */
	private Currency amount;

	/**
	 * Default Constructor
	 */
	public RefundDetail() {
	}

	/**
	 * Parameterized Constructor
	 */
	public RefundDetail(String type) {
		this.type = type;
	}
}
