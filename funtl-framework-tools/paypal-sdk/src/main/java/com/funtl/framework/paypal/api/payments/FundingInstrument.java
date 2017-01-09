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
public class FundingInstrument extends PayPalModel {

	/**
	 * Credit Card instrument.
	 */
	private CreditCard creditCard;

	/**
	 * PayPal vaulted credit Card instrument.
	 */
	private CreditCardToken creditCardToken;

	/**
	 * Payment Card information.
	 */
	private PaymentCard paymentCard;

	/**
	 * Bank Account information.
	 */
	private ExtendedBankAccount bankAccount;

	/**
	 * Vaulted bank account instrument.
	 */
	private BankToken bankAccountToken;

	/**
	 * PayPal credit funding instrument.
	 */
	private Credit credit;

	/**
	 * Incentive funding instrument.
	 */
	private Incentive incentive;

	/**
	 * External funding instrument.
	 */
	private ExternalFunding externalFunding;

	/**
	 * Carrier account token instrument.
	 */
	private CarrierAccountToken carrierAccountToken;

	/**
	 * Carrier account instrument
	 */
	private CarrierAccount carrierAccount;

	/**
	 * Private Label Card funding instrument. These are store cards provided by merchants to drive business with value to customer with convenience and rewards.
	 */
	private PrivateLabelCard privateLabelCard;

	/**
	 * Billing instrument that references pre-approval information for the payment
	 */
	private Billing billing;

	/**
	 * Alternate Payment  information - Mostly regional payment providers. For e.g iDEAL in Netherlands
	 */
	private AlternatePayment alternatePayment;

	/**
	 * Default Constructor
	 */
	public FundingInstrument() {
	}

}
