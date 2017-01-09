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
public class InvoiceItem extends PayPalModel {

	/**
	 * Name of the item. 200 characters max.
	 */
	private String name;

	/**
	 * Description of the item. 1000 characters max.
	 */
	private String description;

	/**
	 * Quantity of the item. Range of -10000 to 10000.
	 */
	private float quantity;

	/**
	 * Unit price of the item. Range of -1,000,000 to 1,000,000.
	 */
	private Currency unitPrice;

	/**
	 * Tax associated with the item.
	 */
	private Tax tax;

	/**
	 * The date when the item or service was provided. The date format is *yyyy*-*MM*-*dd* *z* as defined in [Internet Date/Time Format](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String date;

	/**
	 * The item discount, as a percent or an amount value.
	 */
	private Cost discount;

	/**
	 * The image URL. Maximum length is 4000 characters.
	 */
	private String imageUrl;

	/**
	 * The unit of measure of the item being invoiced.
	 */
	private String unitOfMeasure;

	/**
	 * Default Constructor
	 */
	public InvoiceItem() {
	}

	/**
	 * Parameterized Constructor
	 */
	public InvoiceItem(String name, float quantity, Currency unitPrice) {
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
}
