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
public class RecipientBankingInstruction extends PayPalModel {

	/**
	 * Name of the financial institution.
	 */
	private String bankName;

	/**
	 * Name of the account holder
	 */
	private String accountHolderName;

	/**
	 * bank account number
	 */
	private String accountNumber;

	/**
	 * bank routing number
	 */
	private String routingNumber;

	/**
	 * IBAN equivalent of the bank
	 */
	private String internationalBankAccountNumber;

	/**
	 * BIC identifier of the financial institution
	 */
	private String bankIdentifierCode;

	/**
	 * Default Constructor
	 */
	public RecipientBankingInstruction() {
	}

	/**
	 * Parameterized Constructor
	 */
	public RecipientBankingInstruction(String bankName, String accountHolderName, String internationalBankAccountNumber) {
		this.bankName = bankName;
		this.accountHolderName = accountHolderName;
		this.internationalBankAccountNumber = internationalBankAccountNumber;
	}
}
