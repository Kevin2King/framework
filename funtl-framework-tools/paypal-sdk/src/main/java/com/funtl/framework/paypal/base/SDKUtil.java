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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.funtl.framework.paypal.base.rest.PayPalRESTException;

/**
 * SDKUtil class holds utility methods for processing data transformation
 */
public final class SDKUtil {

	private SDKUtil() {
	}

	/**
	 * Constructs a Map<String, String> from a {@link Properties} object by
	 * combining the default values. See {@link ConfigManager} for default
	 * values
	 *
	 * @param properties Input {@link Properties}
	 * @return Map<String, String>
	 */
	public static Map<String, String> constructMap(Properties properties) {
		Properties combinedProperties = ConfigManager.combineDefaultProperties(properties);
		Map<String, String> propsMap = new HashMap<String, String>();

		// Since the default properties are only searchable
		Enumeration<?> keys = combinedProperties.propertyNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement().toString().trim();
			String value = combinedProperties.getProperty(key).trim();
			propsMap.put(key, value);
		}
		return propsMap;
	}

	/**
	 * Combines some {@link Map} with default values. See {@link ConfigManager}
	 * for default values.
	 *
	 * @param receivedMap {@link Map} used to combine with Default {@link Map}
	 * @return Combined {@link Map}
	 */
	public static Map<String, String> combineDefaultMap(Map<String, String> receivedMap) {
		return combineMap(receivedMap, ConfigManager.getDefaultSDKMap());
	}

	public static Map<String, String> combineMap(Map<String, String> highMap, Map<String, String> lowMap) {
		lowMap = lowMap != null ? lowMap : new HashMap<String, String>();
		highMap = highMap != null ? highMap : new HashMap<String, String>();
		lowMap.putAll(highMap);
		return lowMap;
	}

	/**
	 * Utility method to validate if the key exists in the provided map, and
	 * returns string value of the object
	 *
	 * @param map Map of String based key and values
	 * @param key object to be found in the key
	 * @return String value of the key
	 * @throws PayPalRESTException
	 */
	public static String validateAndGet(Map<String, String> map, String key) throws PayPalRESTException {
		if (map == null || key == null) {
			throw new PayPalRESTException("Map or Key cannot be null");
		}
		String value = map.get(key);
		if (value == null || value.equals("")) {
			for (Iterator<Entry<String, String>> itemIter = map.entrySet().iterator(); itemIter.hasNext(); ) {
				Entry<String, String> entry = itemIter.next();
				if (entry.getKey().equalsIgnoreCase(key)) {
					value = entry.getValue();
					break;
				}
			}

			if (value == null || value.equals("")) {
				throw new PayPalRESTException(key + " cannot be null");
			}
		}
		return value;
	}

}
