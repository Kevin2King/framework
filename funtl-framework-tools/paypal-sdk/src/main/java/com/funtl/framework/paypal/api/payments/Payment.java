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
import java.util.Map;

import com.funtl.framework.paypal.base.rest.APIContext;
import com.funtl.framework.paypal.base.rest.HttpMethod;
import com.funtl.framework.paypal.base.rest.JSONFormatter;
import com.funtl.framework.paypal.base.rest.PayPalRESTException;
import com.funtl.framework.paypal.base.rest.PayPalResource;
import com.funtl.framework.paypal.base.rest.RESTUtil;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@SuppressWarnings({"deprecation"})
public class Payment extends PayPalResource {

	/**
	 * Identifier of the payment resource created.
	 */
	private String id;

	/**
	 * Payment intent.
	 */
	private String intent;

	/**
	 * Source of the funds for this payment represented by a PayPal account or a direct credit card.
	 */
	private Payer payer;

	/**
	 * Information that the merchant knows about the payer.  This information is not definitive and only serves as a hint to the UI or any pre-processing logic.
	 */
	private PotentialPayerInfo potentialPayerInfo;

	/**
	 * Receiver of funds for this payment. **Readonly for PayPal external REST payments.**
	 */
	private Payee payee;

	/**
	 * ID of the cart to execute the payment.
	 */
	private String cart;

	/**
	 * Transactional details including the amount and item details.
	 */
	private List<Transaction> transactions;

	/**
	 * Applicable for advanced payments like multi seller payment (MSP) to support partial failures
	 */
	private List<Error> failedTransactions;

	/**
	 * Collection of PayPal generated billing agreement tokens.
	 */
	private List<BillingAgreementToken> billingAgreementTokens;

	/**
	 * Credit financing offered to payer on PayPal side. Returned in payment after payer opts-in
	 */
	private CreditFinancingOffered creditFinancingOffered;

	/**
	 * Instructions for the payer to complete this payment.
	 */
	private PaymentInstruction paymentInstruction;

	/**
	 * The state of the payment, authorization, or order transaction. The value is:<ul><li><code>created</code>. The transaction was successfully created.</li><li><code>approved</code>. The buyer approved the transaction.</li><li><code>failed</code>. The transaction request failed.</li></ul>
	 */
	private String state;

	/**
	 * PayPal generated identifier for the merchant's payment experience profile. Refer to [this](https://developer.paypal.com/docs/api/#payment-experience) link to create experience profile ID.
	 */
	private String experienceProfileId;

	/**
	 * free-form field for the use of clients to pass in a message to the payer
	 */
	private String noteToPayer;

	/**
	 * Set of redirect URLs you provide only for PayPal-based payments.
	 */
	private RedirectUrls redirectUrls;

	/**
	 * Failure reason code returned when the payment failed for some valid reasons.
	 */
	private String failureReason;

	/**
	 * Payment creation time as defined in [RFC 3339 Section 5.6](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String createTime;

	/**
	 * Payment update time as defined in [RFC 3339 Section 5.6](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String updateTime;

	/**
	 *
	 */
	private List<Links> links;

	/**
	 * Default Constructor
	 */
	public Payment() {
	}

	/**
	 * Parameterized Constructor
	 */
	public Payment(String intent, Payer payer) {
		this.intent = intent;
		this.payer = payer;
	}

	/**
	 * Creates and processes a payment. In the JSON request body, include a `payment` object with the intent, payer, and transactions. For PayPal payments, include redirect URLs in the `payment` object.
	 *
	 * @param accessToken Access Token used for the API call.
	 * @return Payment
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #create(APIContext)} instead.
	 */
	public Payment create(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return create(apiContext);
	}

	/**
	 * Creates and processes a payment. In the JSON request body, include a `payment` object with the intent, payer, and transactions. For PayPal payments, include redirect URLs in the `payment` object.
	 *
	 * @param apiContext {@link APIContext} used for the API call.
	 * @return Payment
	 * @throws PayPalRESTException
	 */
	public Payment create(APIContext apiContext) throws PayPalRESTException {
		String resourcePath = "v1/payments/payment";
		String payLoad = this.toJSON();
		Payment payment = configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Payment.class);
		apiContext.setRequestId(null);
		return payment;
	}


	/**
	 * Shows details for a payment, by ID.
	 *
	 * @param accessToken Access Token used for the API call.
	 * @param paymentId   String
	 * @return Payment
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #get(APIContext, String)} instead.
	 */
	public static Payment get(String accessToken, String paymentId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return get(apiContext, paymentId);
	}

	/**
	 * Shows details for a payment, by ID.
	 *
	 * @param apiContext {@link APIContext} used for the API call.
	 * @param paymentId  String
	 * @return Payment
	 * @throws PayPalRESTException
	 */
	public static Payment get(APIContext apiContext, String paymentId) throws PayPalRESTException {
		if (paymentId == null) {
			throw new IllegalArgumentException("paymentId cannot be null");
		}
		Object[] parameters = new Object[]{paymentId};
		String pattern = "v1/payments/payment/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Payment.class);
	}


	/**
	 * Executes the payment (after approved by the Payer) associated with this resource when the payment method is PayPal.
	 *
	 * @param accessToken      Access Token used for the API call.
	 * @param paymentExecution PaymentExecution
	 * @return Payment
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #execute(APIContext, PaymentExecution)} instead.
	 */
	public Payment execute(String accessToken, PaymentExecution paymentExecution) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return execute(apiContext, paymentExecution);
	}

	/**
	 * Executes, or completes, a PayPal payment that the payer has approved. You can optionally update selective payment information when you execute a payment.
	 *
	 * @param apiContext       {@link APIContext} used for the API call.
	 * @param paymentExecution PaymentExecution
	 * @return Payment
	 * @throws PayPalRESTException
	 */
	public Payment execute(APIContext apiContext, PaymentExecution paymentExecution) throws PayPalRESTException {
		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		if (paymentExecution == null) {
			throw new IllegalArgumentException("paymentExecution cannot be null");
		}
		Object[] parameters = new Object[]{this.getId()};
		String pattern = "v1/payments/payment/{0}/execute";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = paymentExecution.toJSON();
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Payment.class);
	}

	/**
	 * Partially update a payment resource by by passing the payment_id in the request URI. In addition, pass a patch_request_object in the body of the request JSON that specifies the operation to perform, path of the target location, and new value to apply. Please note that it is not possible to use patch after execute has been called.
	 *
	 * @param accessToken  Access Token used for the API call.
	 * @param patchRequest List<Patch>
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #update(APIContext, List)} instad.
	 */
	public void update(String accessToken, List<Patch> patchRequest) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		update(apiContext, patchRequest);
	}

	/**
	 * Partially update a payment resource by by passing the payment_id in the request URI. In addition, pass a patch_request_object in the body of the request JSON that specifies the operation to perform, path of the target location, and new value to apply. Please note that it is not possible to use patch after execute has been called.
	 *
	 * @param apiContext   {@link APIContext} used for the API call.
	 * @param patchRequest List<Patch>
	 * @throws PayPalRESTException
	 */
	public void update(APIContext apiContext, List<Patch> patchRequest) throws PayPalRESTException {

		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		if (patchRequest == null) {
			throw new IllegalArgumentException("patchRequest cannot be null");
		}
		Object[] parameters = new Object[]{this.getId()};
		String pattern = "v1/payments/payment/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = JSONFormatter.toJSON(patchRequest);
		PayPalResource.configureAndExecute(apiContext, HttpMethod.PATCH, resourcePath, payLoad, null);
	}


	/**
	 * List payments that were made to the merchant who issues the request. Payments can be in any state.
	 *
	 * @param accessToken  Access Token used for the API call.
	 * @param containerMap Map<String, String>
	 * @return PaymentHistory
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #list(APIContext, Map)} instead.
	 */
	public static PaymentHistory list(String accessToken, Map<String, String> containerMap) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return list(apiContext, containerMap);
	}

	/**
	 * List payments that were made to the merchant who issues the request. Payments can be in any state.
	 *
	 * @param apiContext   {@link APIContext} used for the API call.
	 * @param containerMap Map<String, String>
	 * @return PaymentHistory
	 * @throws PayPalRESTException
	 */
	public static PaymentHistory list(APIContext apiContext, Map<String, String> containerMap) throws PayPalRESTException {
		if (containerMap == null) {
			throw new IllegalArgumentException("containerMap cannot be null");
		}
		Object[] parameters = new Object[]{containerMap};
		String pattern = "v1/payments/payment?count={0}&start_id={1}&start_index={2}&start_time={3}&end_time={4}&payee_id={5}&sort_by={6}&sort_order={7}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		PaymentHistory paymentHistory = configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, PaymentHistory.class);
		apiContext.setRequestId(null);
		return paymentHistory;
	}

}
