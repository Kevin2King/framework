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
public class Order extends PayPalResource {

	/**
	 * Identifier of the order transaction.
	 */
	private String id;

	/**
	 * Identifier to the purchase unit associated with this object. Obsolete. Use one in cart_base.
	 */
	private String purchaseUnitReferenceId;

	/**
	 * @deprecated Use {@link #purchaseUnitReferenceId} instead
	 * Identifier to the purchase unit associated with this object. Obsolete. Use one in cart_base.
	 */
	@Deprecated
	private String referenceId;

	/**
	 * Amount being collected.
	 */
	private Amount amount;

	/**
	 * specifies payment mode of the transaction
	 */
	private String paymentMode;

	/**
	 * State of the order transaction.
	 */
	private String state;

	/**
	 * Reason code for the transaction state being Pending or Reversed. This field will replace pending_reason field eventually. Only supported when the `payment_method` is set to `paypal`.
	 */
	private String reasonCode;

	/**
	 * @deprecated Reason code for the transaction state being Pending. Obsolete. Retained for backward compatability. Use reason_code field above instead.
	 */
	@Deprecated
	private String pendingReason;

	/**
	 * The level of seller protection in force for the transaction.
	 */
	private String protectionEligibility;

	/**
	 * The kind of seller protection in force for the transaction. This property is returned only when the `protection_eligibility` property is set to `ELIGIBLE`or `PARTIALLY_ELIGIBLE`. Only supported when the `payment_method` is set to `paypal`. Allowed values:<br> `ITEM_NOT_RECEIVED_ELIGIBLE`- Sellers are protected against claims for items not received.<br> `UNAUTHORIZED_PAYMENT_ELIGIBLE`- Sellers are protected against claims for unauthorized payments.<br> One or both of the allowed values can be returned.
	 */
	private String protectionEligibilityType;

	/**
	 * ID of the Payment resource that this transaction is based on.
	 */
	private String parentPayment;

	/**
	 * Fraud Management Filter (FMF) details applied for the payment that could result in accept/deny/pending action.
	 */
	private FmfDetails fmfDetails;

	/**
	 * Time the resource was created in UTC ISO8601 format.
	 */
	private String createTime;

	/**
	 * Time the resource was last updated in UTC ISO8601 format.
	 */
	private String updateTime;

	/**
	 *
	 */
	private List<Links> links;

	/**
	 * Default Constructor
	 */
	public Order() {
	}

	/**
	 * Parameterized Constructor
	 */
	public Order(Amount amount) {
		this.amount = amount;
	}

	/**
	 * Shows details for an order, by ID.
	 *
	 * @param accessToken Access Token used for the API call.
	 * @param orderId     String
	 * @return Order
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #get(APIContext, String)} instead.
	 */
	public static Order get(String accessToken, String orderId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return get(apiContext, orderId);
	}

	/**
	 * Shows details for an order, by ID.
	 *
	 * @param apiContext {@link APIContext} used for the API call.
	 * @param orderId    String
	 * @return Order
	 * @throws PayPalRESTException
	 */
	public static Order get(APIContext apiContext, String orderId) throws PayPalRESTException {
		if (orderId == null) {
			throw new IllegalArgumentException("orderId cannot be null");
		}
		Object[] parameters = new Object[]{orderId};
		String pattern = "v1/payments/orders/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Order.class);
	}


	/**
	 * Captures a payment for an order, by ID. To use this call, the original payment call must specify an intent of `order`. In the JSON request body, include the payment amount and indicate whether this capture is the final capture for the authorization.
	 *
	 * @param accessToken Access Token used for the API call.
	 * @param capture     Capture
	 * @return Capture
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #capture(APIContext, Capture)} instead.
	 */
	public Capture capture(String accessToken, Capture capture) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return capture(apiContext, capture);
	}

	/**
	 * Captures a payment for an order, by ID. To use this call, the original payment call must specify an intent of `order`. In the JSON request body, include the payment amount and indicate whether this capture is the final capture for the authorization.
	 *
	 * @param apiContext {@link APIContext} used for the API call.
	 * @param capture    Capture
	 * @return Capture
	 * @throws PayPalRESTException
	 */
	public Capture capture(APIContext apiContext, Capture capture) throws PayPalRESTException {
		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		if (capture == null) {
			throw new IllegalArgumentException("capture cannot be null");
		}
		Object[] parameters = new Object[]{this.getId()};
		String pattern = "v1/payments/orders/{0}/capture";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = capture.toJSON();
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Capture.class);
	}


	/**
	 * Voids, or cancels, an order, by ID. You cannot void an order if a payment has already been partially or fully captured.
	 *
	 * @param accessToken Access Token used for the API call.
	 * @return Order
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #doVoid(APIContext)} instead.
	 */
	public Order doVoid(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return doVoid(apiContext);
	}

	/**
	 * Voids, or cancels, an order, by ID. You cannot void an order if a payment has already been partially or fully captured.
	 *
	 * @param apiContext {@link APIContext} used for the API call.
	 * @return Order
	 * @throws PayPalRESTException
	 */
	public Order doVoid(APIContext apiContext) throws PayPalRESTException {
		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		Object[] parameters = new Object[]{this.getId()};
		String pattern = "v1/payments/orders/{0}/do-void";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Order.class);
	}


	/**
	 * Authorizes an order, by ID. Include an `amount` object in the JSON request body.
	 *
	 * @param accessToken Access Token used for the API call.
	 * @return Authorization
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #authorize(APIContext)} instead.
	 */
	public Authorization authorize(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return authorize(apiContext);
	}

	/**
	 * Authorizes an order, by ID. Include an `amount` object in the JSON request body.
	 *
	 * @param apiContext {@link APIContext} used for the API call.
	 * @return Authorization
	 * @throws PayPalRESTException
	 */
	public Authorization authorize(APIContext apiContext) throws PayPalRESTException {
		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		Object[] parameters = new Object[]{this.getId()};
		String pattern = "v1/payments/orders/{0}/authorize";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = this.toJSON();
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Authorization.class);
	}

}
