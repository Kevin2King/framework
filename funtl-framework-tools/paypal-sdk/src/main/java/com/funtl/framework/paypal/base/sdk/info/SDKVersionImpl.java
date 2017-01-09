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

package com.funtl.framework.paypal.base.sdk.info;

import com.funtl.framework.paypal.base.SDKVersion;

/**
 * Implementation of SDKVersion
 */
public class SDKVersionImpl implements SDKVersion {

	/**
	 * SDK ID used in User-Agent HTTP header
	 */
	private static final String SDK_ID = "PayPal-Java-SDK";

	/**
	 * SDK Version used in User-Agent HTTP header
	 */
	private static final String SDK_VERSION = "1.13.0";

	public String getSDKId() {
		return SDK_ID;
	}

	public String getSDKVersion() {
		return SDK_VERSION;
	}

}
