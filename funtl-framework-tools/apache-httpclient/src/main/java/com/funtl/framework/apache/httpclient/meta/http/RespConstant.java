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

package com.funtl.framework.apache.httpclient.meta.http;

/**
 * Author: Lusifer
 */
public interface RespConstant {
	public static final String XML_ANNOUNCEMENT = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";

	public static final String XML_RESP_OPEN = "<resp>";
	public static final String XML_RESP_CLOSE = "</resp>";

	public static final String XML_HEAD_OPEN = "<head>";
	public static final String XML_HEAD_CLOSE = "</head>";

	public static final String XML_STATUS_OPEN = "<status>";
	public static final String XML_STATUS_CLOSE = "</status>";

	public static final String XML_DESC_OPEN = "<desc><![CDATA[";
	public static final String XML_DESC_CLOSE = "]]></desc>";

	public static final String XML_PAGE_OPEN = "<page>";
	public static final String XML_PAGE_CLOSE = "</page>";

	public static final String XML_TOTAL_OPEN = "<total>";
	public static final String XML_TOTAL_CLOSE = "</total>";

	public static final String XML_DATA_OPEN = "<data>";
	public static final String XML_DATA_CLOSE = "</data>";

	public static final String XML_PIDX_OPEN = "<pidx>";
	public static final String XML_PIDX_CLOSE = "</pidx>";

	public static final StringBuffer JSON_ERROR = new StringBuffer("{\"desc\":\"build json failed\",\"status\":1007}");
	public static final StringBuilder ERROR_JSON = new StringBuilder("{\"desc\":\"build json failed\",\"status\":1007}");

	public static final String JSON_STATUS = "status";
	public static final String JSON_DESC = "desc";
	public static final String JSON_PAGE = "page";
	public static final String JSON_TOTAL = "total";
	public static final String JSON_DATA = "data";
	public static final String JSON_EXTEND_DATA = "extend_data";
	public static final String JSON_PIDX = "pidx";
	public static final String JSON_VERSION = "version";
	public static final String LAST_TIME_STAMP = "lastTimeStamp";//时间分页的返回
}
