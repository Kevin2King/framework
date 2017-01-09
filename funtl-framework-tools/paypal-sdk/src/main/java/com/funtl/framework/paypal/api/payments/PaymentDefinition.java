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
public class PaymentDefinition extends PayPalModel {

	/**
	 * Identifier of the payment_definition. 128 characters max.
	 */
	private String id;

	/**
	 * Name of the payment definition. 128 characters max.
	 */
	private String name;

	/**
	 * Type of the payment definition. Allowed values: `TRIAL`, `REGULAR`.
	 */
	private String type;

	/**
	 * How frequently the customer should be charged.
	 */
	private String frequencyInterval;

	/**
	 * Frequency of the payment definition offered. Allowed values: `WEEK`, `DAY`, `YEAR`, `MONTH`.
	 */
	private String frequency;

	/**
	 * Number of cycles in this payment definition.
	 */
	private String cycles;

	/**
	 * Amount that will be charged at the end of each cycle for this payment definition.
	 */
	private Currency amount;

	/**
	 * Array of charge_models for this payment definition.
	 */
	private List<ChargeModels> chargeModels;

	/**
	 * Default Constructor
	 */
	public PaymentDefinition() {
	}

	/**
	 * Parameterized Constructor
	 */
	public PaymentDefinition(String name, String type, String frequencyInterval, String frequency, String cycles, Currency amount) {
		this.name = name;
		this.type = type;
		this.frequencyInterval = frequencyInterval;
		this.frequency = frequency;
		this.cycles = cycles;
		this.amount = amount;
	}
}
