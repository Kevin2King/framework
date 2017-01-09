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

import com.funtl.framework.paypal.base.rest.APIContext;
import com.funtl.framework.paypal.base.rest.HttpMethod;
import com.funtl.framework.paypal.base.rest.PayPalRESTException;
import com.funtl.framework.paypal.base.rest.PayPalResource;
import com.funtl.framework.paypal.base.rest.RESTUtil;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Refund extends PayPalResource {

	/**
	 * ID of the refund transaction. 17 characters max.
	 */
	private String id;

	/**
	 * Details including both refunded amount (to payer) and refunded fee (to payee). 10 characters max.
	 */
	private Amount amount;

	/**
	 * State of the refund.
	 */
	private String state;

	/**
	 * Reason description for the Sale transaction being refunded.
	 */
	private String reason;

	/**
	 * Your own invoice or tracking ID number. Character length and limitations: 127 single-byte alphanumeric characters.
	 */
	private String invoiceNumber;

	/**
	 * ID of the Sale transaction being refunded.
	 */
	private String saleId;

	/**
	 * ID of the sale transaction being refunded.
	 */
	private String captureId;

	/**
	 * ID of the payment resource on which this transaction is based.
	 */
	private String parentPayment;

	/**
	 * Description of what is being refunded for.
	 */
	private String description;

	/**
	 * Time of refund as defined in [RFC 3339 Section 5.6](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String createTime;

	/**
	 * Time that the resource was last updated.
	 */
	private String updateTime;

	/**
	 * The reason code for the refund state being pending
	 */
	private String reasonCode;

	/**
	 *
	 */
	private List<Links> links;

	/**
	 * Default Constructor
	 */
	public Refund() {
	}


	/**
	 * Shows details for a refund, by ID.
	 *
	 * @param accessToken Access Token used for the API call.
	 * @param refundId    String
	 * @return Refund
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #get(APIContext, String)} instead.
	 */
	public static Refund get(String accessToken, String refundId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return get(apiContext, refundId);
	}

	/**
	 * Shows details for a refund, by ID.
	 *
	 * @param apiContext {@link APIContext} used for the API call.
	 * @param refundId   String
	 * @return Refund
	 * @throws PayPalRESTException
	 */
	public static Refund get(APIContext apiContext, String refundId) throws PayPalRESTException {
		if (refundId == null) {
			throw new IllegalArgumentException("refundId cannot be null");
		}
		Object[] parameters = new Object[]{refundId};
		String pattern = "v1/payments/refund/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Refund.class);
	}

}
