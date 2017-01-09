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
public class InvoicingMetaData extends PayPalModel {

	/**
	 * Date when the resource was created.
	 */
	private String createdDate;

	/**
	 * Email address of the account that created the resource.
	 */
	private String createdBy;

	/**
	 * Date when the resource was cancelled.
	 */
	private String cancelledDate;

	/**
	 * Actor who cancelled the resource.
	 */
	private String cancelledBy;

	/**
	 * Date when the resource was last edited.
	 */
	private String lastUpdatedDate;

	/**
	 * Email address of the account that last edited the resource.
	 */
	private String lastUpdatedBy;

	/**
	 * Date when the resource was first sent.
	 */
	private String firstSentDate;

	/**
	 * Date when the resource was last sent.
	 */
	private String lastSentDate;

	/**
	 * Email address of the account that last sent the resource.
	 */
	private String lastSentBy;

	/**
	 * Default Constructor
	 */
	public InvoicingMetaData() {
	}
}
