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
public class MerchantInfo extends PayPalModel {

	/**
	 * The merchant email address. Maximum length is 260 characters.
	 */
	private String email;

	/**
	 * The merchant first name. Maximum length is 30 characters.
	 */
	private String firstName;

	/**
	 * The merchant last name. Maximum length is 30 characters.
	 */
	private String lastName;

	/**
	 * The merchant address.
	 */
	private InvoiceAddress address;

	/**
	 * The merchant company business name. Maximum length is 100 characters.
	 */
	private String businessName;

	/**
	 * The merchant phone number.
	 */
	private Phone phone;

	/**
	 * The merchant fax number.
	 */
	private Phone fax;

	/**
	 * The merchant website. Maximum length is 2048 characters.
	 */
	private String website;

	/**
	 * The merchant tax ID. Maximum length is 100 characters.
	 */
	private String taxId;

	/**
	 * Option to provide a label to the additional_info field. 40 characters max.
	 */
	private String additionalInfoLabel;

	/**
	 * Additional information, such as business hours. Maximum length is 40 characters.
	 */
	private String additionalInfo;

	/**
	 * Default Constructor
	 */
	public MerchantInfo() {
	}

	/**
	 * Parameterized Constructor
	 */
	public MerchantInfo(String email) {
		this.email = email;
	}
}
