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

import java.util.HashMap;
import java.util.Map;

import com.funtl.framework.paypal.api.payments.PaymentHistory;

/**
 * <code>QueryParameters</code> holds query parameters used for retrieving
 * {@link PaymentHistory} object.
 */
public class QueryParameters {

	/**
	 * Count
	 */
	private static final String COUNT = "count";

	/**
	 * Start Id
	 */
	private static final String STARTID = "start_id";

	/**
	 * Start Index
	 */
	private static final String STARTINDEX = "start_index";

	/**
	 * Start Time
	 */
	private static final String STARTTIME = "start_time";

	/**
	 * End Time
	 */
	private static final String ENDTIME = "end_time";

	/**
	 * Payee Id
	 */
	private static final String PAYEEID = "payee_id";

	/**
	 * Sort By
	 */
	private static final String SORTBY = "sort_by";

	/**
	 * Sort Order
	 */
	private static final String SORTORDER = "sort_order";

	// Map backing QueryParameters intended to processed
	// by SDK library 'RESTUtil'
	private Map<String, String> containerMap;

	public QueryParameters() {
		containerMap = new HashMap<String, String>();
	}

	/**
	 * @return the containerMap
	 */
	public Map<String, String> getContainerMap() {
		return containerMap;
	}

	/**
	 * Set the count
	 *
	 * @param count Number of items to return.
	 */
	public void setCount(String count) {
		containerMap.put(COUNT, count);
	}

	/**
	 * Set the startId
	 *
	 * @param startId Resource ID that indicates the starting resource to return.
	 */
	public void setStartId(String startId) {
		containerMap.put(STARTID, startId);
	}

	/**
	 * Set the startIndex
	 *
	 * @param startIndex Start index of the resources to be returned. Typically used to
	 *                   jump to a specific position in the resource history based on
	 *                   its order.
	 */
	public void setStartIndex(String startIndex) {
		containerMap.put(STARTINDEX, startIndex);
	}

	/**
	 * Set the startTime
	 *
	 * @param startTime Resource creation time that indicates the start of a range of
	 *                  results.
	 */
	public void setStartTime(String startTime) {
		containerMap.put(STARTTIME, startTime);
	}

	/**
	 * Set the endTime
	 *
	 * @param endTime Resource creation time that indicates the end of a range of
	 *                results.
	 */
	public void setEndTime(String endTime) {
		containerMap.put(ENDTIME, endTime);
	}

	/**
	 * Set the payeeId
	 *
	 * @param payeeId PayeeId
	 */
	public void setPayeeId(String payeeId) {
		containerMap.put(PAYEEID, payeeId);
	}

	/**
	 * Set the sortBy
	 *
	 * @param sortBy Sort based on create_time or update_time.
	 */
	public void setSortBy(String sortBy) {
		containerMap.put(SORTBY, sortBy);
	}

	/**
	 * Set the sortOrder
	 *
	 * @param sortOrder Sort based on order of results. Options include asc for
	 *                  ascending order or dec for descending order.
	 */
	public void setSortOrder(String sortOrder) {
		containerMap.put(SORTORDER, sortOrder);
	}

}
