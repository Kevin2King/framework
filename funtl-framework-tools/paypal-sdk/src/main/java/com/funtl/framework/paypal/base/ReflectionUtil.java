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

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public final class ReflectionUtil {

	private ReflectionUtil() {
	}

	public static Map<String, String> decodeResponseObject(Object responseType, String prefix) {
		Map<String, String> returnMap = new HashMap<String, String>();
		Map<String, Object> rMap = ReflectionUtil.generateMapFromResponse(responseType, "");
		if (rMap != null && rMap.size() > 0) {
			for (Entry<String, Object> entry : rMap.entrySet()) {
				returnMap.put(entry.getKey(), entry.toString());
			}
		}
		return returnMap;
	}

	public static Map<String, Object> generateMapFromResponse(Object responseType, String prefix) {

		if (responseType == null) {
			return null;
		}

		Map<String, Object> responseMap = new HashMap<String, Object>();

		// To check return types
		Map<String, Object> returnMap;
		Object returnObject;

		try {
			Class klazz = responseType.getClass();
			Method[] methods = klazz.getMethods();
			Package packageName;
			String propertyName;
			AccessibleObject.setAccessible(methods, true);
			for (Method m : methods) {
				if (m.getName().startsWith("get") && !m.getName().equalsIgnoreCase("getClass")) {
					packageName = m.getReturnType().getPackage();
					try {
						if (prefix != null && prefix.length() != 0) {
							propertyName = prefix + "." + m.getName().substring(3, 4).toLowerCase(Locale.US) + m.getName().substring(4);
						} else {
							propertyName = m.getName().substring(3, 4).toLowerCase(Locale.US) + m.getName().substring(4);

						}
						if (packageName != null) {
							if (!packageName.getName().contains("com.paypal")) {
								returnObject = m.invoke(responseType, new Object[0]);
								if (returnObject != null && List.class.isAssignableFrom(m.getReturnType())) {
									List listObj = (List) returnObject;
									int i = 0;
									for (Object o : listObj) {
										if (o.getClass().getPackage().getName().contains("com.paypal")) {
											responseMap.putAll(generateMapFromResponse(o, propertyName + "(" + i + ")"));
										} else {
											responseMap.put(propertyName + "(" + i + ")", o);
										}
										i++;
									}

								} else if (returnObject != null) {
									if (responseType.getClass().getSimpleName().equalsIgnoreCase("ErrorParameter") && propertyName.endsWith("value")) {
										propertyName = propertyName.substring(0, propertyName.lastIndexOf('.'));
									}
									responseMap.put(propertyName, returnObject);
								}
							} else {
								returnObject = m.invoke(responseType, new Object[0]);
								if (returnObject != null && m.getReturnType().isEnum()) {
									responseMap.put(propertyName, returnObject.getClass().getMethod("getValue", new Class[0]).invoke(returnObject, new Object[0]));
								} else if (returnObject != null) {
									returnMap = generateMapFromResponse(returnObject, propertyName);
									if (returnMap != null && returnMap.size() > 0) {
										responseMap.putAll(returnMap);
									}
								}
							}

						} else {
							responseMap.put(propertyName, m.invoke(klazz.newInstance(), new Object[0]));
						}
					} catch (IllegalAccessException e) {
					} catch (IllegalArgumentException e) {
					} catch (InvocationTargetException e) {
					} catch (InstantiationException e) {
					}
				}
			}
		} catch (Exception e) {
			return null;
		}
		return responseMap;
	}

}
