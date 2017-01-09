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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class NVPUtil {

	private NVPUtil() {
	}

	/**
	 * Utility method used to decode the nvp response String
	 *
	 * @param nvpString
	 * @return Map
	 * @throws UnsupportedEncodingException
	 */
	public static Map<String, String> decode(String nvpString) throws UnsupportedEncodingException {
		String[] nmValPairs = nvpString.split("&");
		Map<String, String> response = new HashMap<String, String>();

		// parse the string and load into the object
		for (String nmVal : nmValPairs) {
			String[] field = nmVal.split("=");
			response.put(URLDecoder.decode(field[0], Constants.ENCODING_FORMAT), (field.length > 1) ? URLDecoder.decode(field[1].trim(), Constants.ENCODING_FORMAT) : "");
		}
		return response;
	}

	/**
	 * Utility method used to encode the value
	 *
	 * @param value
	 * @return String
	 * @throws UnsupportedEncodingException
	 */
	public static String encodeUrl(String value) throws UnsupportedEncodingException {
		return URLEncoder.encode(value, Constants.ENCODING_FORMAT);
	}

}
