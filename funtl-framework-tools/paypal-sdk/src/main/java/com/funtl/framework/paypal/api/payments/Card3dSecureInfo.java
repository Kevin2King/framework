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
public class Card3dSecureInfo extends PayPalModel {

	/**
	 * Authorization status from 3ds provider. Should be echoed back in the response
	 */
	private String authStatus;

	/**
	 * Numeric flag to indicate how the payment should be processed in relationship to 3d-secure. If 0 then ignore all 3d values and process as non-3ds
	 */
	private String eci;

	/**
	 * Cardholder Authentication Verification Value (used by VISA).
	 */
	private String cavv;

	/**
	 * Transaction identifier from authenticator.
	 */
	private String xid;

	/**
	 * Name of the actual 3ds vendor who processed the 3ds request, e.g. Cardinal
	 */
	private String mpiVendor;

	/**
	 * Default Constructor
	 */
	public Card3dSecureInfo() {
	}
}
