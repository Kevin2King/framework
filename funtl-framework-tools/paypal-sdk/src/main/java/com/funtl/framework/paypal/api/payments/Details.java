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
public class Details extends PayPalModel {

	/**
	 * Amount of the subtotal of the items. **Required** if line items are specified. 10 characters max, with support for 2 decimal places.
	 */
	private String subtotal;

	/**
	 * Amount charged for shipping. 10 characters max with support for 2 decimal places.
	 */
	private String shipping;

	/**
	 * Amount charged for tax. 10 characters max with support for 2 decimal places.
	 */
	private String tax;

	/**
	 * Amount being charged for the handling fee. Only supported when the `payment_method` is set to `paypal`.
	 */
	private String handlingFee;

	/**
	 * Amount being discounted for the shipping fee. Only supported when the `payment_method` is set to `paypal`.
	 */
	private String shippingDiscount;

	/**
	 * Amount being charged for the insurance fee. Only supported when the `payment_method` is set to `paypal`.
	 */
	private String insurance;

	/**
	 * Amount being charged as gift wrap fee.
	 */
	private String giftWrap;

	/**
	 * Fee charged by PayPal. In case of a refund, this is the fee amount refunded to the original receipient of the payment.
	 */
	private String fee;

	/**
	 * Default Constructor
	 */
	public Details() {
	}

}
