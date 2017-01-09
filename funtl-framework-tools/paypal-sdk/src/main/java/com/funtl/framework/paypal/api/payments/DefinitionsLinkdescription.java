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

import com.funtl.framework.paypal.base.rest.PayPalModel;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class DefinitionsLinkdescription extends PayPalModel {

	/**
	 * a URI template, as defined by RFC 6570, with the addition of the $, ( and ) characters for pre-processing
	 */
	private String href;

	/**
	 * relation to the target resource of the link
	 */
	private String rel;

	/**
	 * a title for the link
	 */
	private String title;

	/**
	 * JSON Schema describing the link target
	 */
	private DefinitionsLinkdescription targetSchema;

	/**
	 * media type (as defined by RFC 2046) describing the link target
	 */
	private String mediaType;

	/**
	 * method for requesting the target of the link (e.g. for HTTP this might be "GET" or "DELETE")
	 */
	private String method;

	/**
	 * The media type in which to submit data along with the request
	 */
	private String encType;

	/**
	 * Schema describing the data to submit along with the request
	 */
	private DefinitionsLinkdescription schema;

	/**
	 * Default Constructor
	 */
	public DefinitionsLinkdescription() {
	}

	/**
	 * Parameterized Constructor
	 */
	public DefinitionsLinkdescription(String href, String rel) {
		this.href = href;
		this.rel = rel;
	}
}
