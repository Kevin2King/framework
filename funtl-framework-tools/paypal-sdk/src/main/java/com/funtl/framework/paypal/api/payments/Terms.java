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
public class Terms extends PayPalModel {

	/**
	 * Identifier of the terms. 128 characters max.
	 */
	private String id;

	/**
	 * Term type. Allowed values: `MONTHLY`, `WEEKLY`, `YEARLY`.
	 */
	private String type;

	/**
	 * Max Amount associated with this term.
	 */
	private Currency maxBillingAmount;

	/**
	 * How many times money can be pulled during this term.
	 */
	private String occurrences;

	/**
	 * Amount_range associated with this term.
	 */
	private Currency amountRange;

	/**
	 * Buyer's ability to edit the amount in this term.
	 */
	private String buyerEditable;

	/**
	 * Default Constructor
	 */
	public Terms() {
	}

	/**
	 * Parameterized Constructor
	 */
	public Terms(String type, Currency maxBillingAmount, String occurrences, Currency amountRange, String buyerEditable) {
		this.type = type;
		this.maxBillingAmount = maxBillingAmount;
		this.occurrences = occurrences;
		this.amountRange = amountRange;
		this.buyerEditable = buyerEditable;
	}
}
