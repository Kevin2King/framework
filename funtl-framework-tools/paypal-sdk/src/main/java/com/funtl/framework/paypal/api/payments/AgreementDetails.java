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
public class AgreementDetails extends PayPalModel {

	/**
	 * The outstanding balance for this agreement.
	 */
	private Currency outstandingBalance;

	/**
	 * Number of cycles remaining for this agreement.
	 */
	private String cyclesRemaining;

	/**
	 * Number of cycles completed for this agreement.
	 */
	private String cyclesCompleted;

	/**
	 * The next billing date for this agreement, represented as 2014-02-19T10:00:00Z format.
	 */
	private String nextBillingDate;

	/**
	 * Last payment date for this agreement, represented as 2014-06-09T09:42:31Z format.
	 */
	private String lastPaymentDate;

	/**
	 * Last payment amount for this agreement.
	 */
	private Currency lastPaymentAmount;

	/**
	 * Last payment date for this agreement, represented as 2015-02-19T10:00:00Z format.
	 */
	private String finalPaymentDate;

	/**
	 * Total number of failed payments for this agreement.
	 */
	private String failedPaymentCount;

	/**
	 * Default Constructor
	 */
	public AgreementDetails() {
	}
}
