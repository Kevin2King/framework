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
public class Capture extends PayPalResource {

	/**
	 * The ID of the capture transaction.
	 */
	private String id;

	/**
	 * The amount to capture. If the amount matches the orginally authorized amount, the state of the authorization changes to `captured`. If not, the state of the authorization changes to `partially_captured`.
	 */
	private Amount amount;

	/**
	 * Indicates whether to release all remaining funds that the authorization holds in the funding instrument. Default is `false`.
	 */
	private Boolean isFinalCapture;

	/**
	 * The state of the capture.
	 */
	private String state;

	/**
	 * The reason code that describes why the transaction state is pending or reversed.
	 */
	private String reasonCode;

	/**
	 * The ID of the payment on which this transaction is based.
	 */
	private String parentPayment;

	/**
	 * The invoice number to track this payment.
	 */
	private String invoiceNumber;

	/**
	 * The transaction fee for this payment.
	 */
	private Currency transactionFee;

	/**
	 * The date and time of capture, as defined in [RFC 3339 Section 5.6](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String createTime;

	/**
	 * The date and time when the resource was last updated.
	 */
	private String updateTime;

	/**
	 *
	 */
	private List<Links> links;

	/**
	 * Default Constructor
	 */
	public Capture() {
	}

	/**
	 * Shows details for a captured payment, by ID.
	 *
	 * @param accessToken Access Token used for the API call.
	 * @param captureId   String
	 * @return Capture
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #get(APIContext, String)} instead.
	 */
	public static Capture get(String accessToken, String captureId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return get(apiContext, captureId);
	}

	/**
	 * Shows details for a captured payment, by ID.
	 *
	 * @param apiContext {@link APIContext} used for the API call.
	 * @param captureId  String
	 * @return Capture
	 * @throws PayPalRESTException
	 */
	public static Capture get(APIContext apiContext, String captureId) throws PayPalRESTException {

		if (captureId == null) {
			throw new IllegalArgumentException("captureId cannot be null");
		}
		Object[] parameters = new Object[]{captureId};
		String pattern = "v1/payments/capture/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Capture.class);
	}


	/**
	 * Creates (and processes) a new Refund Transaction added as a related resource.
	 *
	 * @param accessToken Access Token used for the API call.
	 * @param refund      Refund
	 * @return Refund
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #refund(APIContext, Refund)} instead.
	 */
	public Refund refund(String accessToken, Refund refund) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return refund(apiContext, refund);
	}

	/**
	 * @param apiContext {@link APIContext} used for the API call.
	 * @param refund     Refund
	 * @return Refund
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #refund(APIContext, RefundRequest)} instead
	 * Refunds a captured payment, by ID. Include an `amount` object in the JSON request body.
	 */
	public Refund refund(APIContext apiContext, Refund refund) throws PayPalRESTException {

		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		if (refund == null) {
			throw new IllegalArgumentException("refund cannot be null");
		}
		apiContext.setRequestId(null);
		Object[] parameters = new Object[]{this.getId()};
		String pattern = "v1/payments/capture/{0}/refund";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = refund.toJSON();
		Refund refundResponse = configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Refund.class);
		apiContext.setRequestId(null);
		return refundResponse;
	}

	/**
	 * Refunds a captured payment, by ID. Include an `amount` object in the JSON request body.
	 *
	 * @param apiContext    {@link APIContext} used for the API call.
	 * @param refundRequest RefundRequest
	 * @return DetailedRefund
	 * @throws PayPalRESTException
	 */
	public DetailedRefund refund(APIContext apiContext, RefundRequest refundRequest) throws PayPalRESTException {
		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		if (refundRequest == null) {
			throw new IllegalArgumentException("refundRequest cannot be null");
		}
		Object[] parameters = new Object[]{this.getId()};
		String pattern = "v1/payments/capture/{0}/refund";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = refundRequest.toJSON();
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, DetailedRefund.class);
	}

}
