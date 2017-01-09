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
public class FlowConfig extends PayPalModel {

	/**
	 * The type of landing page to display on the PayPal site for user checkout. Set to `Billing` to use the non-PayPal account landing page. Set to `Login` to use the PayPal account login landing page.
	 */
	private String landingPageType;

	/**
	 * The merchant site URL to display after a bank transfer payment. Valid for only the Giropay or bank transfer payment method in Germany.
	 */
	private String bankTxnPendingUrl;

	/**
	 * Defines whether buyers can complete purchases on the PayPal or merchant website.
	 */
	private String userAction;

	/**
	 * Defines the HTTP method to use to redirect the user to a return URL. A valid value is `GET` or `POST`.
	 */
	private String returnUriHttpMethod;

	/**
	 * Default Constructor
	 */
	public FlowConfig() {
	}

}
