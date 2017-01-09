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

package com.funtl.framework.paypal.base;

import java.util.Map;

import com.funtl.framework.paypal.base.exception.ClientActionRequiredException;
import com.funtl.framework.paypal.base.exception.OAuthException;
import com.funtl.framework.paypal.base.rest.OAuthTokenCredential;
import com.funtl.framework.paypal.base.rest.RESTAPICallPreHandler;

/**
 * <code>APICallPreHandler</code> defines a high level abstraction for call
 * specific operations. PayPal REST API is provided by {@link RESTAPICallPreHandler}
 */
public interface APICallPreHandler {

	/**
	 * Returns headers for HTTP call
	 *
	 * @return Map of headers with name and value
	 * @throws OAuthException
	 */
	Map<String, String> getHeaderMap() throws OAuthException;

	/**
	 * Returns the payload for the API call. The implementation should take care
	 * in formatting the payload appropriately
	 *
	 * @return Payload as String
	 */
	String getPayLoad();

	/**
	 * Returns the endpoint for the API call. The implementation may calculate
	 * the endpoint depending on parameters set on it. If no endpoint is found
	 * in the passed configuration, then SANDBOX endpoints (hardcoded in
	 * {@link Constants})are taken to be default for the API call.
	 *
	 * @return Endpoint String.
	 */
	String getEndPoint();

	/**
	 * Returns {@link OAuthTokenCredential} configured for the api call
	 *
	 * @return ICredential object
	 */
	OAuthTokenCredential getCredential();

	/**
	 * Validates settings and integrity before call
	 *
	 * @throws ClientActionRequiredException
	 */
	void validate() throws ClientActionRequiredException;


	/**
	 * Return configurationMap
	 *
	 * @return configurationMap in this call pre-handler
	 */
	public Map<String, String> getConfigurationMap();

}
