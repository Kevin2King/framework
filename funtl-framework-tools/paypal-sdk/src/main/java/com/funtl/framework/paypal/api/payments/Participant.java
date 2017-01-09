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
public class Participant extends PayPalModel {

	/**
	 * The participant email address.
	 */
	private String email;

	/**
	 * The participant first name.
	 */
	private String firstName;

	/**
	 * The participant last name.
	 */
	private String lastName;

	/**
	 * The participant company business name.
	 */
	private String businessName;

	/**
	 * The participant phone number.
	 */
	private Phone phone;

	/**
	 * The participant fax number.
	 */
	private Phone fax;

	/**
	 * The participant website.
	 */
	private String website;

	/**
	 * Additional information, such as business hours.
	 */
	private String additionalInfo;

	/**
	 * The participant address.
	 */
	private InvoiceAddress address;

	/**
	 * Default Constructor
	 */
	public Participant() {
	}

	/**
	 * Parameterized Constructor
	 */
	public Participant(String email) {
		this.email = email;
	}
}
