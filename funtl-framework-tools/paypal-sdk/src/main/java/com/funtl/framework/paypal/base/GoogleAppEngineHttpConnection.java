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

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

import com.funtl.framework.paypal.base.exception.SSLConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A special HttpConnection for use on Google App Engine.
 * <p>
 * In order to activate this feature, set 'http.GoogleAppEngine = true' in the
 * SDK config file.
 */
public class GoogleAppEngineHttpConnection extends HttpConnection {

	private static final Logger log = LoggerFactory.getLogger(GoogleAppEngineHttpConnection.class);

	@Override
	public void setupClientSSL(String certPath, String certKey) throws SSLConfigurationException {

		if (certPath != null || certKey != null) {
			log.warn("The PayPal SDK cannot be used with client SSL on Google App Engine; configure the SDK to use a PayPal API Signature instead");
		}
	}

	@Override
	public void createAndconfigureHttpConnection(HttpConfiguration clientConfiguration) throws IOException {

		this.config = clientConfiguration;

		URL url = new URL(this.config.getEndPointUrl());

		// Google App Engine does not support the
		// javax.net.ssl.HttpsURLConnection class.
		// However, one can use use URL.openConnection() with a https:// URL and
		// it will
		// return an HttpURLConnection that is capable of retrieving HTTPS data.
		// see
		// https://groups.google.com/forum/?fromgroups#!topic/google-appengine-java/ZEskGLwyE_0

		// Google App Engine does not require any proxy settings so we can skip
		// that configuration entirely.

		// Other Google issues that can be starred to add better support:
		// http://code.google.com/p/googleappengine/issues/detail?id=1036

		this.connection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
		this.connection.setDoInput(true);
		this.connection.setDoOutput(true);
		this.connection.setRequestMethod(config.getHttpMethod());
		this.connection.setConnectTimeout(this.config.getConnectionTimeout());
		this.connection.setReadTimeout(this.config.getReadTimeout());
	}

}
