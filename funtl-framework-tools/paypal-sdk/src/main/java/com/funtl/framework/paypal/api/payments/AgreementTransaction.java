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
public class AgreementTransaction extends PayPalModel {

	/**
	 * Id corresponding to this transaction.
	 */
	private String transactionId;

	/**
	 * State of the subscription at this time.
	 */
	private String status;

	/**
	 * Type of transaction, usually Recurring Payment.
	 */
	private String transactionType;

	/**
	 * Amount for this transaction.
	 */
	private Currency amount;

	/**
	 * Fee amount for this transaction.
	 */
	private Currency feeAmount;

	/**
	 * Net amount for this transaction.
	 */
	private Currency netAmount;

	/**
	 * Email id of payer.
	 */
	private String payerEmail;

	/**
	 * Business name of payer.
	 */
	private String payerName;

	/**
	 * Time zone of time_updated field.
	 */
	private String timeZone;

	/**
	 * Time at which this transaction happened.
	 */
	private String timeStamp;

	/**
	 * Default Constructor
	 */
	public AgreementTransaction() {
	}

	/**
	 * Parameterized Constructor
	 */
	public AgreementTransaction(Currency amount, Currency feeAmount, Currency netAmount) {
		this.amount = amount;
		this.feeAmount = feeAmount;
		this.netAmount = netAmount;
	}

	/**
	 * @deprecated use setTimeStamp instead.
	 * Setter for timeUpdated
	 */
	public AgreementTransaction setTimeUpdated(String timeUpdated) {
		this.timeStamp = timeUpdated;
		return this;
	}

	/**
	 * @deprecated use getTimeStamp instead.
	 * Getter for timeUpdated
	 */
	public String getTimeUpdated() {
		return this.timeStamp;
	}
}
