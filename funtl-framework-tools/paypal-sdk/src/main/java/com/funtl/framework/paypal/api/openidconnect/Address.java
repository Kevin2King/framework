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

package com.funtl.framework.paypal.api.openidconnect;

import com.funtl.framework.paypal.base.rest.PayPalModel;

public class Address extends PayPalModel {

	/**
	 * Full street address component, which may include house number, street name.
	 */
	private String streetAddress;
	
	/**
	 * City or locality component.
	 */
	private String locality;
	
	/**
	 * State, province, prefecture or region component.
	 */
	private String region;
	
	/**
	 * Zip code or postal code component.
	 */
	private String postalCode;
	
	/**
	 * Country name component.
	 */
	private String country;
	
	/**
	 * Default Constructor
	 */
	public Address() {
	}

	/**
	 * Setter for streetAddress
	 * @param streetAddress 
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
 	}
 	
 	/**
	 * Getter for streetAddress
	 */
	public String getStreetAddress() {
		return this.streetAddress;
	}
	
	/**
	 * Setter for locality
	 */
	public void setLocality(String locality) {
		this.locality = locality;
 	}
 	
 	/**
	 * Getter for locality
	 */
	public String getLocality() {
		return this.locality;
	}
	
	/**
	 * Setter for region
	 */
	public void setRegion(String region) {
		this.region = region;
 	}
 	
 	/**
	 * Getter for region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Setter for postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
 	}
 	
 	/**
	 * Getter for postalCode
	 */
	public String getPostalCode() {
		return this.postalCode;
	}
	
	/**
	 * Setter for country
	 */
	public void setCountry(String country) {
		this.country = country;
 	}
 	
 	/**
	 * Getter for country
	 */
	public String getCountry() {
		return this.country;
	}

}
