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
public class CreditFinancingOffered extends PayPalModel {

	/**
	 * This is the estimated total payment amount including interest and fees the user will pay during the lifetime of the loan.
	 */
	private Currency totalCost;

	/**
	 * Length of financing terms in month
	 */
	private float term;

	/**
	 * This is the estimated amount per month that the customer will need to pay including fees and interest.
	 */
	private Currency monthlyPayment;

	/**
	 * Estimated interest or fees amount the payer will have to pay during the lifetime of the loan.
	 */
	private Currency totalInterest;

	/**
	 * Status on whether the customer ultimately was approved for and chose to make the payment using the approved installment credit.
	 */
	private Boolean payerAcceptance;

	/**
	 * Indicates whether the cart amount is editable after payer's acceptance on PayPal side
	 */
	private Boolean cartAmountImmutable;

	/**
	 * Default Constructor
	 */
	public CreditFinancingOffered() {
	}

	/**
	 * Parameterized Constructor
	 */
	public CreditFinancingOffered(Currency totalCost, float term, Currency monthlyPayment, Currency totalInterest, Boolean payerAcceptance) {
		this.totalCost = totalCost;
		this.term = term;
		this.monthlyPayment = monthlyPayment;
		this.totalInterest = totalInterest;
		this.payerAcceptance = payerAcceptance;
	}
}
