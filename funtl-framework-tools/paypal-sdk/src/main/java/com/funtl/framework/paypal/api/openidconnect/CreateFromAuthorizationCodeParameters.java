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

package com.funtl.framework.paypal.api.openidconnect;

import java.util.HashMap;
import java.util.Map;

import com.funtl.framework.paypal.base.ClientCredentials;

public class CreateFromAuthorizationCodeParameters extends ClientCredentials {

	/**
	 * Code
	 */
	private static final String CODE = "code";

	/**
	 * Redirect URI
	 */
	private static final String REDIRECTURI = "redirect_uri";

	/**
	 * Grant Type
	 */
	private static final String GRANTTYPE = "grant_type";

	// Map backing QueryParameters intended to processed
	// by SDK library 'RESTUtil'
	private Map<String, String> containerMap;

	public CreateFromAuthorizationCodeParameters() {
		containerMap = new HashMap<String, String>();
		containerMap.put(GRANTTYPE, "authorization_code");
	}

	/**
	 * @return the containerMap
	 */
	public Map<String, String> getContainerMap() {
		return containerMap;
	}

	/**
	 * Set the code
	 *
	 * @param code
	 */
	public void setCode(String code) {
		containerMap.put(CODE, code);
	}

	/**
	 * Set the redirect URI
	 *
	 * @param redirectURI
	 */
	public void setRedirectURI(String redirectURI) {
		containerMap.put(REDIRECTURI, redirectURI);
	}

	/**
	 * Set the Grant Type
	 *
	 * @param grantType
	 */
	public void setGrantType(String grantType) {
		containerMap.put(GRANTTYPE, grantType);
	}

}
