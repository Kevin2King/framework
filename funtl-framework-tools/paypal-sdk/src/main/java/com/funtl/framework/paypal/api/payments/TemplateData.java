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
public class TemplateData extends PayPalModel {

	/**
	 * Information about the merchant who is sending the invoice.
	 */
	private MerchantInfo merchantInfo;

	/**
	 * The required invoice recipient email address and any optional billing information. One recipient is supported.
	 */
	private List<BillingInfo> billingInfo;

	/**
	 * For invoices sent by email, one or more email addresses to which to send a Cc: copy of the notification. Supports only email addresses under participant.
	 */
	private List<String> ccInfo;

	/**
	 * The shipping information for entities to whom items are being shipped.
	 */
	private ShippingInfo shippingInfo;

	/**
	 * The list of items to include in the invoice. Maximum value is 100 items per invoice.
	 */
	private List<InvoiceItem> items;

	/**
	 * Optional. The payment deadline for the invoice. Value is either `term_type` or `due_date` but not both.
	 */
	private PaymentTerm paymentTerm;

	/**
	 * Reference data, such as PO number, to add to the invoice. Maximum length is 60 characters.
	 */
	private String reference;

	/**
	 * The invoice level discount, as a percent or an amount value.
	 */
	private Cost discount;

	/**
	 * The shipping cost, as a percent or an amount value.
	 */
	private ShippingCost shippingCost;

	/**
	 * The custom amount to apply on an invoice. If you include a label, the amount cannot be empty.
	 */
	private CustomAmount custom;

	/**
	 * Indicates whether the invoice allows a partial payment. If set to `false`, invoice must be paid in full. If set to `true`, the invoice allows partial payments. Default is `false`.
	 */
	private Boolean allowPartialPayment;

	/**
	 * If `allow_partial_payment` is set to `true`, the minimum amount allowed for a partial payment.
	 */
	private Currency minimumAmountDue;

	/**
	 * Indicates whether tax is calculated before or after a discount. If set to `false`, the tax is calculated before a discount. If set to `true`, the tax is calculated after a discount. Default is `false`.
	 */
	private Boolean taxCalculatedAfterDiscount;

	/**
	 * Indicates whether the unit price includes tax. Default is `false`.
	 */
	private Boolean taxInclusive;

	/**
	 * General terms of the invoice. 4000 characters max.
	 */
	private String terms;

	/**
	 * Note to the payer. 4000 characters max.
	 */
	private String note;

	/**
	 * A private bookkeeping memo for the merchant. Maximum length is 150 characters.
	 */
	private String merchantMemo;

	/**
	 * Full URL of an external image to use as the logo. Maximum length is 4000 characters.
	 */
	private String logoUrl;

	/**
	 * The total amount of the invoice.
	 */
	private Currency totalAmount;

	/**
	 * List of files attached to the invoice.
	 */
	private List<FileAttachment> attachments;

	/**
	 * Default Constructor
	 */
	public TemplateData() {
	}

	/**
	 * Parameterized Constructor
	 */
	public TemplateData(MerchantInfo merchantInfo) {
		this.merchantInfo = merchantInfo;
	}
}
