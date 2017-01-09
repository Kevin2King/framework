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
public class PayoutItemDetails extends PayPalModel {

	/**
	 * The ID for the payout item. Viewable when you show details for a batch payout.
	 */
	private String payoutItemId;

	/**
	 * The PayPal-generated ID for the transaction.
	 */
	private String transactionId;

	/**
	 * The transaction status.
	 */
	private String transactionStatus;

	/**
	 * The amount of money, in U.S. dollars, for fees.
	 */
	private Currency payoutItemFee;

	/**
	 * The PayPal-generated ID for the batch payout.
	 */
	private String payoutBatchId;

	/**
	 * A sender-specified ID number. Tracks the batch payout in an accounting system.
	 */
	private String senderBatchId;

	/**
	 * The sender-provided information for the payout item.
	 */
	private PayoutItem payoutItem;

	/**
	 * The date and time when this item was last processed.
	 */
	private String timeProcessed;

	/**
	 *
	 */
	private Error errors;

	/**
	 * The HATEOAS links related to the call.
	 */
	private List<Links> links;

	/**
	 * Default Constructor
	 */
	public PayoutItemDetails() {
	}

	/**
	 * Parameterized Constructor
	 */
	public PayoutItemDetails(String payoutItemId, String payoutBatchId, PayoutItem payoutItem, String timeProcessed) {
		this.payoutItemId = payoutItemId;
		this.payoutBatchId = payoutBatchId;
		this.payoutItem = payoutItem;
		this.timeProcessed = timeProcessed;
	}

	/**
	 * Setter for error. Please use this over {@link #setErrors(Error)}.
	 * errors field in {@link PayoutItemDetails} takes one {@link Error} object.
	 * Not using lombok autogeneration as `setErrors` is not a feasible option.
	 */
	public PayoutItemDetails setError(Error error) {
		this.errors = error;
		return this;
	}

	/**
	 * Getter for error. Please use this over {@link #getErrors()}.
	 * errors field in {@link PayoutItemDetails} takes one {@link Error} object.
	 */
	public Error getError() {
		return this.errors;
	}

}
