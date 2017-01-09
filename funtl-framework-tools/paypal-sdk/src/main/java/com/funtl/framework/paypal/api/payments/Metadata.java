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
public class Metadata extends PayPalModel {

	/**
	 * The date and time when the resource was created.
	 */
	private String createdDate;

	/**
	 * The email address of the account that created the resource.
	 */
	private String createdBy;

	/**
	 * The date and time when the resource was cancelled.
	 */
	private String cancelledDate;

	/**
	 * The actor who cancelled the resource.
	 */
	private String cancelledBy;

	/**
	 * The date and time when the resource was last edited.
	 */
	private String lastUpdatedDate;

	/**
	 * The email address of the account that last edited the resource.
	 */
	private String lastUpdatedBy;

	/**
	 * The date and time when the resource was first sent.
	 */
	private String firstSentDate;

	/**
	 * The date and time when the resource was last sent.
	 */
	private String lastSentDate;

	/**
	 * The email address of the account that last sent the resource.
	 */
	private String lastSentBy;

	/**
	 * URL representing the payer's view of the invoice.
	 */
	private String payerViewUrl;

	/**
	 * Default Constructor
	 */
	public Metadata() {
	}
}
