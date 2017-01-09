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
public class Authorization extends PayPalResource {

	/**
	 * ID of the authorization transaction.
	 */
	private String id;

	/**
	 * Amount being authorized.
	 */
	private Amount amount;

	/**
	 * Specifies the payment mode of the transaction.
	 */
	private String paymentMode;

	/**
	 * State of the authorization.
	 */
	private String state;

	/**
	 * Reason code, `AUTHORIZATION`, for a transaction state of `pending`.
	 */
	private String reasonCode;

	/**
	 * [DEPRECATED] Reason code for the transaction state being Pending.Obsolete. use reason_code field instead.
	 */
	private String pendingReason;

	/**
	 * The level of seller protection in force for the transaction. Only supported when the `payment_method` is set to `paypal`. Allowed values:<br>  `ELIGIBLE`- Merchant is protected by PayPal's Seller Protection Policy for Unauthorized Payments and Item Not Received.<br> `PARTIALLY_ELIGIBLE`- Merchant is protected by PayPal's Seller Protection Policy for Item Not Received or Unauthorized Payments. Refer to `protection_eligibility_type` for specifics. <br> `INELIGIBLE`- Merchant is not protected under the Seller Protection Policy.
	 */
	private String protectionEligibility;

	/**
	 * The kind of seller protection in force for the transaction. This property is returned only when the `protection_eligibility` property is set to `ELIGIBLE`or `PARTIALLY_ELIGIBLE`. Only supported when the `payment_method` is set to `paypal`. Allowed values:<br> `ITEM_NOT_RECEIVED_ELIGIBLE`- Sellers are protected against claims for items not received.<br> `UNAUTHORIZED_PAYMENT_ELIGIBLE`- Sellers are protected against claims for unauthorized payments.<br> One or both of the allowed values can be returned.
	 */
	private String protectionEligibilityType;

	/**
	 * Fraud Management Filter (FMF) details applied for the payment that could result in accept, deny, or pending action. Returned in a payment response only if the merchant has enabled FMF in the profile settings and one of the fraud filters was triggered based on those settings. See [Fraud Management Filters Summary](https://developer.paypal.com/docs/classic/fmf/integration-guide/FMFSummary/) for more information.
	 */
	private FmfDetails fmfDetails;

	/**
	 * ID of the Payment resource that this transaction is based on.
	 */
	private String parentPayment;

	/**
	 * Authorization expiration time and date as defined in [RFC 3339 Section 5.6](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String validUntil;

	/**
	 * Time of authorization as defined in [RFC 3339 Section 5.6](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String createTime;

	/**
	 * Time that the resource was last updated.
	 */
	private String updateTime;

	/**
	 * Identifier to the purchase or transaction unit corresponding to this authorization transaction.
	 */
	private String referenceId;

	/**
	 * Receipt id is 16 digit number payment identification number returned for guest users to identify the payment.
	 */
	private String receiptId;

	/**
	 *
	 */
	private List<Links> links;

	/**
	 * Default Constructor
	 */
	public Authorization() {
	}

	/**
	 * Parameterized Constructor
	 */
	public Authorization(Amount amount) {
		this.amount = amount;
	}

	/**
	 * Shows details for an authorization, by ID.
	 *
	 * @param accessToken     Access Token used for the API call.
	 * @param authorizationId String
	 * @return Authorization
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #get(APIContext, String)} instead.
	 */
	public static Authorization get(String accessToken, String authorizationId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return get(apiContext, authorizationId);
	}

	/**
	 * Shows details for an authorization, by ID.
	 *
	 * @param apiContext      {@link APIContext} used for the API call.
	 * @param authorizationId String
	 * @return Authorization
	 * @throws PayPalRESTException
	 */
	public static Authorization get(APIContext apiContext, String authorizationId) throws PayPalRESTException {
		if (authorizationId == null) {
			throw new IllegalArgumentException("authorizationId cannot be null");
		}
		Object[] parameters = new Object[]{authorizationId};
		String pattern = "v1/payments/authorization/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Authorization.class);
	}


	/**
	 * Captures and processes an authorization, by ID. To use this call, the original payment call must specify an intent of `authorize`.
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
	 * Captures and processes an authorization, by ID. To use this call, the original payment call must specify an intent of `authorize`.
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
		String pattern = "v1/payments/authorization/{0}/capture";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = capture.toJSON();
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Capture.class);
	}


	/**
	 * Voids, or cancels, an authorization, by ID. You cannot void a fully captured authorization.
	 *
	 * @param accessToken Access Token used for the API call.
	 * @return Authorization
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #doVoid(APIContext)} instead.
	 */
	public Authorization doVoid(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return doVoid(apiContext);
	}

	/**
	 * Voids, or cancels, an authorization, by ID. You cannot void a fully captured authorization.
	 *
	 * @param apiContext {@link APIContext} used for the API call.
	 * @return Authorization
	 * @throws PayPalRESTException
	 */
	public Authorization doVoid(APIContext apiContext) throws PayPalRESTException {
		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		Object[] parameters = new Object[]{this.getId()};
		String pattern = "v1/payments/authorization/{0}/void";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Authorization.class);
	}


	/**
	 * Reauthorizes a PayPal account payment, by authorization ID. To ensure that funds are still available, reauthorize a payment after the initial three-day honor period. Supports only the `amount` request parameter.
	 *
	 * @param accessToken Access Token used for the API call.
	 * @return Authorization
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #reauthorize(APIContext)} instead.
	 */
	public Authorization reauthorize(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return reauthorize(apiContext);
	}

	/**
	 * Reauthorizes a PayPal account payment, by authorization ID. To ensure that funds are still available, reauthorize a payment after the initial three-day honor period. Supports only the `amount` request parameter.
	 *
	 * @param apiContext {@link APIContext} used for the API call.
	 * @return Authorization
	 * @throws PayPalRESTException
	 */
	public Authorization reauthorize(APIContext apiContext) throws PayPalRESTException {
		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		Object[] parameters = new Object[]{this.getId()};
		String pattern = "v1/payments/authorization/{0}/reauthorize";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = this.toJSON();
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Authorization.class);
	}

}
