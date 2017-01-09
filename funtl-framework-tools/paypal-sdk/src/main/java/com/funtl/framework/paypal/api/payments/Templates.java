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

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Templates extends PayPalResource {

	/**
	 * List of addresses in merchant's profile.
	 */
	private List<Address> addresses;

	/**
	 * List of emails in merchant's profile.
	 */
	private List<String> emails;

	/**
	 * List of phone numbers in merchant's profile.
	 */
	private List<Phone> phones;

	/**
	 * Array of templates.
	 */
	private List<Template> templates;

	/**
	 * HATEOS links representing all the actions over the template list returned.
	 */
	private List<Links> links;

	/**
	 * Default Constructor
	 */
	public Templates() {
	}

	/**
	 * Retrieve the details for a particular template by passing the template ID to the request URI.
	 *
	 * @param apiContext {@link APIContext} used for the API call.
	 * @param templateId String
	 * @return Template
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link Template#get(APIContext, String)} instead.
	 */
	public static Template get(APIContext apiContext, String templateId) throws PayPalRESTException {
		return Template.get(apiContext, templateId);
	}

	/**
	 * Retrieves the template information of the merchant.
	 *
	 * @param apiContext {@link APIContext} used for the API call.
	 * @return Templates
	 * @throws PayPalRESTException
	 */
	public static Templates getAll(APIContext apiContext) throws PayPalRESTException {
		String resourcePath = "v1/invoicing/templates";
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Templates.class);
	}

}
