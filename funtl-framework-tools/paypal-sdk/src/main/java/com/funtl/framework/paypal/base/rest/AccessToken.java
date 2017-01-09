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

package com.funtl.framework.paypal.base.rest;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Accessors(chain = true)
public class AccessToken {

	private String accessToken;
	private long expires = 0;

	/**
	 * Specifies how long this token can be used for placing API calls. The
	 * remaining lifetime is given in seconds.
	 *
	 * @return remaining lifetime of this access token in seconds
	 */
	public long expiresIn() {
		return expires - new java.util.Date().getTime() / 1000;
	}

}
