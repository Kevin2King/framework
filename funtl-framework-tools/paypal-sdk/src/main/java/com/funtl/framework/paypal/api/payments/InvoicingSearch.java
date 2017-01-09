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
public class InvoicingSearch extends PayPalModel {

	/**
	 * Initial letters of the email address.
	 */
	private String email;

	/**
	 * Initial letters of the recipient's first name.
	 */
	private String recipientFirstName;

	/**
	 * Initial letters of the recipient's last name.
	 */
	private String recipientLastName;

	/**
	 * Initial letters of the recipient's business name.
	 */
	private String recipientBusinessName;

	/**
	 * The invoice number that appears on the invoice.
	 */
	private String number;

	/**
	 * Status of the invoice.
	 */
	private String status;

	/**
	 * Lower limit of total amount.
	 */
	private Currency lowerTotalAmount;

	/**
	 * Upper limit of total amount.
	 */
	private Currency upperTotalAmount;

	/**
	 * Start invoice date.
	 */
	private String startInvoiceDate;

	/**
	 * End invoice date.
	 */
	private String endInvoiceDate;

	/**
	 * Start invoice due date.
	 */
	private String startDueDate;

	/**
	 * End invoice due date.
	 */
	private String endDueDate;

	/**
	 * Start invoice payment date.
	 */
	private String startPaymentDate;

	/**
	 * End invoice payment date.
	 */
	private String endPaymentDate;

	/**
	 * Start invoice creation date.
	 */
	private String startCreationDate;

	/**
	 * End invoice creation date.
	 */
	private String endCreationDate;

	/**
	 * Offset of the search results.
	 */
	private float page;

	/**
	 * Page size of the search results.
	 */
	private float pageSize;

	/**
	 * A flag indicating whether total count is required in the response.
	 */
	private Boolean totalCountRequired;

	/**
	 * Default Constructor
	 */
	public InvoicingSearch() {
	}
}
