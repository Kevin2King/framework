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
public class PayoutSenderBatchHeader extends PayPalModel {

	/**
	 * A sender-specified ID number. Tracks the batch payout in an accounting system.<blockquote><strong>Note:</strong> PayPal prevents duplicate batches from being processed. If you specify a `sender_batch_id` that was used in the last 30 days, the API rejects the request and returns an error message that indicates the duplicate `sender_batch_id` and includes a HATEOAS link to the original batch payout with the same `sender_batch_id`. If you receive a HTTP `5nn` status code, you can safely retry the request with the same `sender_batch_id`. In any case, the API completes a payment only once for a specific `sender_batch_id` that is used within 30 days.</blockquote>
	 */
	private String senderBatchId;

	/**
	 * The subject line text for the email that PayPal sends when a payout item completes. The subject line is the same for all recipients. Value is an alphanumeric string with a maximum length of 255 single-byte characters.
	 */
	private String emailSubject;

	/**
	 * The type of ID that identifies the payment receiver. Value is:<ul><code>EMAIL</code>. Unencrypted email. Value is a string of up to 127 single-byte characters.</li><li><code>PHONE</code>. Unencrypted phone number.<blockquote><strong>Note:</strong> The PayPal sandbox does not support the <code>PHONE</code> recipient type.</blockquote></li><li><code>PAYPAL_ID</code>. Encrypted PayPal account number.</li></ul>If the <code>sender_batch_header</code> includes the <code>recipient_type</code> attribute, any payout item without its own <code>recipient_type</code> attribute uses the <code>recipient_type</code> value from <code>sender_batch_header</code>. If the <code>sender_batch_header</code> omits the <code>recipient_type</code> attribute, each payout item must include its own <code>recipient_type</code> value.
	 */
	private String recipientType;

	/**
	 * Default Constructor
	 */
	public PayoutSenderBatchHeader() {
	}
}
