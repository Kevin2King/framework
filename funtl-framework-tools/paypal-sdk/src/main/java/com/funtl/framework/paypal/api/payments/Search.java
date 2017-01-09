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
public class Search extends PayPalModel {

	/**
	 * The initial letters of the email address.
	 */
	private String email;

	/**
	 * The initial letters of the recipient's first name.
	 */
	private String recipientFirstName;

	/**
	 * The initial letters of the recipient's last name.
	 */
	private String recipientLastName;

	/**
	 * The initial letters of the recipient's business name.
	 */
	private String recipientBusinessName;

	/**
	 * The invoice number.
	 */
	private String number;

	/**
	 * The invoice status.
	 */
	private String status;

	/**
	 * The lower limit of the total amount.
	 */
	private Currency lowerTotalAmount;

	/**
	 * The upper limit of total amount.
	 */
	private Currency upperTotalAmount;

	/**
	 * The start date for the invoice. Date format is *yyyy*-*MM*-*dd* *z*, as defined in [Internet Date/Time Format](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String startInvoiceDate;

	/**
	 * The end date for the invoice. Date format is *yyyy*-*MM*-*dd* *z*, as defined in [Internet Date/Time Format](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String endInvoiceDate;

	/**
	 * The start due date for the invoice. Date format is *yyyy*-*MM*-*dd* *z*, as defined in [Internet Date/Time Format](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String startDueDate;

	/**
	 * The end due date for the invoice. Date format is *yyyy*-*MM*-*dd* *z*, as defined in [Internet Date/Time Format](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String endDueDate;

	/**
	 * The start payment date for the invoice. Date format is *yyyy*-*MM*-*dd* *z*, as defined in [Internet Date/Time Format](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String startPaymentDate;

	/**
	 * The end payment date for the invoice. Date format is *yyyy*-*MM*-*dd* *z*, as defined in [Internet Date/Time Format](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String endPaymentDate;

	/**
	 * The start creation date for the invoice. Date format is *yyyy*-*MM*-*dd* *z*, as defined in [Internet Date/Time Format](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String startCreationDate;

	/**
	 * The end creation date for the invoice. Date format is *yyyy*-*MM*-*dd* *z*, as defined in [Internet Date/Time Format](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String endCreationDate;

	/**
	 * The offset for the search results.
	 */
	private float page;

	/**
	 * The page size for the search results.
	 */
	private float pageSize;

	/**
	 * Indicates whether the total count appears in the response. Default is `false`.
	 */
	private Boolean totalCountRequired;

	/**
	 * A flag indicating whether search is on invoices archived by merchant. true - returns archived / false returns unarchived / null returns all.
	 */
	private Boolean archived;

	/**
	 * Default Constructor
	 */
	public Search() {
	}

}
