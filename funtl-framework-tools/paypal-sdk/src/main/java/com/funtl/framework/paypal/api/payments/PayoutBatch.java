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
public class PayoutBatch extends PayPalModel {

	/**
	 * A batch header. Includes the generated batch status.
	 */
	private PayoutBatchHeader batchHeader;

	/**
	 * An array of items in a batch payout.
	 */
	private List<PayoutItemDetails> items;

	/**
	 *
	 */
	private List<Links> links;

	/**
	 * Default Constructor
	 */
	public PayoutBatch() {
	}

	/**
	 * Parameterized Constructor
	 */
	public PayoutBatch(PayoutBatchHeader batchHeader, List<PayoutItemDetails> items) {
		this.batchHeader = batchHeader;
		this.items = items;
	}
}
