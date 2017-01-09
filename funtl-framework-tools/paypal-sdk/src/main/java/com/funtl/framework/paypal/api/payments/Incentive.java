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
public class Incentive extends PayPalModel {

	/**
	 * Identifier of the instrument in PayPal Wallet
	 */
	private String id;

	/**
	 * Code that identifies the incentive.
	 */
	private String code;

	/**
	 * Name of the incentive.
	 */
	private String name;

	/**
	 * Description of the incentive.
	 */
	private String description;

	/**
	 * Indicates incentive is applicable for this minimum purchase amount.
	 */
	private Currency minimumPurchaseAmount;

	/**
	 * Logo image url for the incentive.
	 */
	private String logoImageUrl;

	/**
	 * expiry date of the incentive.
	 */
	private String expiryDate;

	/**
	 * Specifies type of incentive
	 */
	private String type;

	/**
	 * URI to the associated terms
	 */
	private String terms;

	/**
	 * Default Constructor
	 */
	public Incentive() {
	}

}
