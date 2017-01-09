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
public class Item extends PayPalModel {

	/**
	 * Stock keeping unit corresponding (SKU) to item.
	 */
	private String sku;

	/**
	 * Item name. 127 characters max.
	 */
	private String name;

	/**
	 * Description of the item. Only supported when the `payment_method` is set to `paypal`.
	 */
	private String description;

	/**
	 * Number of a particular item. 10 characters max.
	 */
	private String quantity;

	/**
	 * Item cost. 10 characters max.
	 */
	private String price;

	/**
	 * 3-letter [currency code](https://developer.paypal.com/docs/integration/direct/rest_api_payment_country_currency_support/).
	 */
	private String currency;

	/**
	 * Tax of the item. Only supported when the `payment_method` is set to `paypal`.
	 */
	private String tax;

	/**
	 * URL linking to item information. Available to payer in transaction history.
	 */
	private String url;

	/**
	 * Category type of the item.
	 */
	private String category;

	/**
	 * Weight of the item.
	 */
	private Measurement weight;

	/**
	 * Length of the item.
	 */
	private Measurement length;

	/**
	 * Height of the item.
	 */
	private Measurement height;

	/**
	 * Width of the item.
	 */
	private Measurement width;

	/**
	 * Set of optional data used for PayPal risk determination.
	 */
	private List<NameValuePair> supplementaryData;

	/**
	 * Set of optional data used for PayPal post-transaction notifications.
	 */
	private List<NameValuePair> postbackData;

	/**
	 * Default Constructor
	 */
	public Item() {
	}

	/**
	 * Parameterized Constructor
	 */
	public Item(String name, String quantity, String price, String currency) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.currency = currency;
	}
}
