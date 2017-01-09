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
public class InputFields extends PayPalModel {

	/**
	 * Indicates whether the buyer can enter a note to the merchant on the PayPal page during checkout.
	 */
	private Boolean allowNote;

	/**
	 * Indicates whether PayPal displays shipping address fields on the experience pages. Valid value is `0`, `1`, or `2`. Set to `0` to display the shipping address on the PayPal pages. Set to `1` to redact shipping address fields from the PayPal pages. Set to `2` to not pass the shipping address but instead get it from the buyer's account profile. For digital goods, this field is required and value must be `1`.
	 */
	private int noShipping;

	/**
	 * Indicates whether to display the shipping address that is passed to this call rather than the one on file with PayPal for this buyer on the PayPal experience pages. Valid value is `0` or `1`. Set to `0` to display the shipping address on file. Set to `1` to display the shipping address supplied to this call; the buyer cannot edit this shipping address.
	 */
	private int addressOverride;

	/**
	 * Default Constructor
	 */
	public InputFields() {
	}

}
