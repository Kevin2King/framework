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

import javax.net.ssl.SSLContext;

/**
 * ConnectionManager acts as a interface to retrieve {@link HttpConnection}
 * objects used by API service
 */
public final class ConnectionManager {

	/**
	 * Singleton instance
	 */
	private static ConnectionManager instance;

	private SSLContext customSslContext;

	// Private Constructor
	private ConnectionManager() {
	}

	/**
	 * Singleton accessor method
	 *
	 * @return {@link ConnectionManager} singleton object
	 */
	public static ConnectionManager getInstance() {
		synchronized (ConnectionManager.class) {
			if (instance == null) {
				instance = new ConnectionManager();
			}
		}
		return instance;
	}

	/**
	 * @return HttpConnection object
	 */
	public HttpConnection getConnection() {
		if (customSslContext != null) {
			return new DefaultHttpConnection(customSslContext);
		} else {
			return new DefaultHttpConnection();
		}
	}

	/**
	 * Overloaded method used factory to load GoogleAppEngineSpecific connection
	 *
	 * @param httpConfig {@link HttpConfiguration} object
	 * @return {@link HttpConnection} object
	 */
	public HttpConnection getConnection(HttpConfiguration httpConfig) {
		if (httpConfig.isGoogleAppEngine()) {
			return new GoogleAppEngineHttpConnection();
		} else {
			return getConnection();
		}
	}

	/**
	 * @param sslContext an custom {@link SSLContext} to set to all new connections.
	 *                   If null, the default SSLContext will be recovered each new connection.<br>
	 *                   <pre>
	 *
	 *                   {@literal // On application startup...}
	 *                   public static void main({@link String}[] args) {
	 *                   	{@link SSLContext} sslContext = {@link SSLContext}.getDefault();
	 *                   	{@literal // Or provide your custom context.}
	 *
	 *                   	{@link ConnectionManager}.getInstance().configureCustomSslContext(sslContext);
	 *                   	{@literal // Now all connections will use this ssl context except if the authentication method is with certificate credential.}
	 *                   }
	 *
	 *                   </pre>
	 */
	public void configureCustomSslContext(SSLContext sslContext) {
		customSslContext = sslContext;
	}
}
