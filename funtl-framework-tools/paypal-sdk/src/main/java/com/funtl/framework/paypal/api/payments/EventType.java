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

import com.funtl.framework.paypal.base.rest.APIContext;
import com.funtl.framework.paypal.base.rest.HttpMethod;
import com.funtl.framework.paypal.base.rest.PayPalRESTException;
import com.funtl.framework.paypal.base.rest.PayPalResource;
import com.funtl.framework.paypal.base.rest.RESTUtil;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class EventType extends PayPalResource {

	/**
	 * Unique event-type name.
	 */
	private String name;

	/**
	 * Human readable description of the event-type
	 */
	private String description;

	/**
	 * Default Constructor
	 */
	public EventType() {
	}

	/**
	 * Parameterized Constructor
	 */
	public EventType(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the list of events-types subscribed by the given Webhook.
	 *
	 * @param accessToken Access Token used for the API call.
	 * @param webhookId   String
	 * @return EventTypeList
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #subscribedEventTypes(APIContext, String)} instead.
	 */
	public static EventTypeList subscribedEventTypes(String accessToken, String webhookId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return subscribedEventTypes(apiContext, webhookId);
	}

	/**
	 * Retrieves the list of events-types subscribed by the given Webhook.
	 *
	 * @param apiContext {@link APIContext} used for the API call.
	 * @param webhookId  String
	 * @return EventTypeList
	 * @throws PayPalRESTException
	 */
	public static EventTypeList subscribedEventTypes(APIContext apiContext, String webhookId) throws PayPalRESTException {

		if (webhookId == null) {
			throw new IllegalArgumentException("webhookId cannot be null");
		}
		Object[] parameters = new Object[]{webhookId};
		String pattern = "v1/notifications/webhooks/{0}/event-types";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		EventTypeList eventTypeList = configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, EventTypeList.class);
		if (eventTypeList == null) {
			eventTypeList = new EventTypeList();
		}

		return eventTypeList;
	}


	/**
	 * Retrieves the master list of available Webhooks events-types resources for any webhook to subscribe to.
	 *
	 * @param accessToken Access Token used for the API call.
	 * @return EventTypeList
	 * @throws PayPalRESTException
	 * @deprecated Please use {@link #availableEventTypes(APIContext)} instead.
	 */
	public static EventTypeList availableEventTypes(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return availableEventTypes(apiContext);
	}

	/**
	 * Retrieves the master list of available Webhooks events-types resources for any webhook to subscribe to.
	 *
	 * @param apiContext {@link APIContext} used for the API call.
	 * @return EventTypeList
	 * @throws PayPalRESTException
	 */
	public static EventTypeList availableEventTypes(APIContext apiContext) throws PayPalRESTException {

		String resourcePath = "v1/notifications/webhooks-event-types";
		String payLoad = "";
		EventTypeList eventTypeList = configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, EventTypeList.class);
		return eventTypeList;
	}


}
