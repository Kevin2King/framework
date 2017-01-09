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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.funtl.framework.paypal.api.openidconnect.CreateFromAuthorizationCodeParameters;
import com.funtl.framework.paypal.api.openidconnect.CreateFromRefreshTokenParameters;
import com.funtl.framework.paypal.api.openidconnect.Tokeninfo;
import com.funtl.framework.paypal.base.Constants;
import com.funtl.framework.paypal.base.rest.APIContext;
import com.funtl.framework.paypal.base.rest.PayPalRESTException;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@SuppressWarnings({"deprecation"})
public class FuturePayment extends Payment {

	/**
	 * Creates a future payment using either authorization code or refresh token
	 * with correlation ID. <br>
	 * https://developer.paypal.com/webapps/developer/docs/integration/mobile/
	 * make-future-payment/
	 *
	 * @param accessToken   an access token
	 * @param correlationId paypal application correlation ID
	 * @return a <code>Payment</code> object
	 * @throws PayPalRESTException
	 * @throws IOException           thrown when config file cannot be read properly
	 * @throws FileNotFoundException thrown when config file does not exist
	 */
	public Payment create(String accessToken, String correlationId) throws PayPalRESTException, FileNotFoundException, IOException {
		if (correlationId == null || correlationId.equals("")) {
			throw new IllegalArgumentException("correlation ID cannot be null or empty");
		}

		APIContext apiContext = new APIContext(accessToken);
		apiContext.addHTTPHeader("PAYPAL-CLIENT-METADATA-ID", correlationId);
		return this.create(apiContext);
	}

	/**
	 * Creates a future payment using either authorization code or refresh token
	 * with correlation ID. <br>
	 * https://developer.paypal.com/webapps/developer/docs/integration/mobile/
	 * make-future-payment/
	 *
	 * @param apiContext    {@link APIContext}
	 * @param correlationId paypal application correlation ID
	 * @return a <code>Payment</code> object
	 * @throws PayPalRESTException
	 * @throws IOException           thrown when config file cannot be read properly
	 * @throws FileNotFoundException thrown when config file does not exist
	 */
	public Payment create(APIContext apiContext, String correlationId) throws PayPalRESTException, FileNotFoundException, IOException {
		if (correlationId == null || correlationId.equals("")) {
			throw new IllegalArgumentException("correlation ID cannot be null or empty");
		}

		apiContext.addHTTPHeader("PAYPAL-CLIENT-METADATA-ID", correlationId);
		return this.create(apiContext);
	}

	/**
	 * @param params Authorization code params
	 * @return {@link Tokeninfo}
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #fetchRefreshToken(APIContext, String)} instead.
	 * In this method, we need to pass clientID, secret information that is already known to apiContext. The newer method allows for better
	 * code readability, and make it less error prone.
	 */
	public Tokeninfo getTokeninfo(CreateFromAuthorizationCodeParameters params) throws PayPalRESTException {
		Map<String, String> configurationMap = new HashMap<String, String>();
		configurationMap.put(Constants.CLIENT_ID, params.getClientID());
		configurationMap.put(Constants.CLIENT_SECRET, params.getClientSecret());
		configurationMap.put("response_type", "token");
		APIContext apiContext = new APIContext();
		apiContext.setConfigurationMap(configurationMap);
		params.setRedirectURI("urn:ietf:wg:oauth:2.0:oob");
		Tokeninfo info = Tokeninfo.createFromAuthorizationCodeForFpp(apiContext, params);
		return info;
	}

	/**
	 * @param params parameters
	 * @return {@link Tokeninfo}
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #fetchRefreshToken(APIContext, String)} instead.
	 * In this method, we need to pass clientID, secret information that is already known to apiContext. The newer method allows for better
	 * code readability, and make it less error prone.
	 */
	public Tokeninfo getTokeninfo(CreateFromRefreshTokenParameters params, Tokeninfo info) throws PayPalRESTException {
		Map<String, String> configurationMap = new HashMap<String, String>();
		APIContext apiContext = new APIContext();
		apiContext.setConfigurationMap(configurationMap);
		info = info.createFromRefreshToken(apiContext, params);
		return info;
	}

	/**
	 * Fetches long lived refresh token from authorization code, for future payment use.
	 *
	 * @param context           {@link APIContext}
	 * @param authorizationCode code returned from mobile
	 * @return String of refresh token
	 * @throws PayPalRESTException
	 */
	public static String fetchRefreshToken(APIContext context, String authorizationCode) throws PayPalRESTException {
		CreateFromAuthorizationCodeParameters params = new CreateFromAuthorizationCodeParameters();
		params.setClientID(context.getClientID());
		params.setClientSecret(context.getClientSecret());
		params.setCode(authorizationCode);
		Tokeninfo info = Tokeninfo.createFromAuthorizationCodeForFpp(context, params);
		return info.getRefreshToken();
	}

}
