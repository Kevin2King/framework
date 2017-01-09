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
public class BillingInfo extends PayPalModel {

	/**
	 * The invoice recipient email address. Maximum length is 260 characters.
	 */
	private String email;

	/**
	 * The invoice recipient first name. Maximum length is 30 characters.
	 */
	private String firstName;

	/**
	 * The invoice recipient last name. Maximum length is 30 characters.
	 */
	private String lastName;

	/**
	 * The invoice recipient company business name. Maximum length is 100 characters.
	 */
	private String businessName;

	/**
	 * The invoice recipient address.
	 */
	private InvoiceAddress address;

	/**
	 * The language in which the email was sent to the payer. Used only when the payer does not have a PayPal account.
	 */
	private String language;

	/**
	 * Additional information, such as business hours. Maximum length is 40 characters.
	 */
	private String additionalInfo;

	/**
	 * Preferred notification channel of the payer. Email by default.
	 */
	private String notificationChannel;

	/**
	 * Mobile Phone number of the recipient to which SMS will be sent if notification_channel is SMS.
	 */
	private Phone phone;

	/**
	 * Default Constructor
	 */
	public BillingInfo() {
	}

	/**
	 * Parameterized Constructor
	 */
	public BillingInfo(String email) {
		this.email = email;
	}
}
