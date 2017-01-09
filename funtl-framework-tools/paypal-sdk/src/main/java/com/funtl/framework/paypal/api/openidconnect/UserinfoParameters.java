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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Class UserinfoParameters
 */
public class UserinfoParameters {

	/**
	 * Schema
	 */
	private static final String SCHEMA = "schema";

	/**
	 * Access Token
	 */
	private static final String ACCESSTOKEN = "access_token";

	// Map backing QueryParameters intended to processed
	// by SDK library 'RESTUtil'
	private Map<String, String> containerMap;

	/**
	 *
	 */
	public UserinfoParameters() {
		containerMap = new HashMap<String, String>();
		containerMap.put(SCHEMA, "openid");
	}

	/**
	 * @return the containerMap
	 */
	public Map<String, String> getContainerMap() {
		return containerMap;
	}

	/**
	 * Set the accessToken
	 *
	 * @param accessToken
	 */
	public void setAccessToken(String accessToken) {
		try {
			containerMap.put(ACCESSTOKEN, URLEncoder.encode(accessToken, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
		}
	}

}
