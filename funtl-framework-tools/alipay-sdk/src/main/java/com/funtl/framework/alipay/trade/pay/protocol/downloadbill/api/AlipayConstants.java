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

package com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api;

/**
 * @author runzhi
 */
public class AlipayConstants {

	public static final String SIGN_TYPE = "sign_type";

	public static final String SIGN_TYPE_RSA = "RSA";

	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

	public static final String APP_ID = "app_id";

	public static final String FORMAT = "format";

	public static final String METHOD = "method";

	public static final String TIMESTAMP = "timestamp";

	public static final String VERSION = "version";

	public static final String SIGN = "sign";

	public static final String ALIPAY_SDK = "alipay_sdk";

	public static final String ACCESS_TOKEN = "auth_token";

	public static final String TERMINAL_TYPE = "terminal_type";

	public static final String TERMINAL_INFO = "terminal_info";

	public static final String CHARSET = "charset";

	public static final String NOTIFY_URL = "notify_url";

	/**
	 * 默认时间格式
	 **/
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * Date默认时区
	 **/
	public static final String DATE_TIMEZONE = "GMT+8";

	/**
	 * UTF-8字符集
	 **/
	public static final String CHARSET_UTF8 = "UTF-8";

	/**
	 * GBK字符集
	 **/
	public static final String CHARSET_GBK = "GBK";

	/**
	 * JSON 应格式
	 */
	public static final String FORMAT_JSON = "json";

	/**
	 * XML 应格式
	 */
	public static final String FORMAT_XML = "xml";

	/**
	 * SDK版本号
	 */
	public static final String SDK_VERSION = "alipay-sdk-java-dynamicVersionNo";

	public static final String PROD_CODE = "prod_code";

	/**
	 * 老版本失败节点
	 */
	public static final String ERROR_RESPONSE = "error_response";

	/**
	 * 新版本节点后缀
	 */
	public static final String RESPONSE_SUFFIX = "_response";

}
