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

package com.funtl.framework.core.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * HttpServletRequest工具类
 * Created by 李卫民 on 2016/8/26.
 */
public class RequestUtils {
	/**
	 * 获取Http请求的服务器名称（如：www.xxx.com）
	 *
	 * @param request
	 * @return
	 */
	public static String getServerName(HttpServletRequest request) {
		String url = "";
		url = request.getScheme() + "://" + request.getServerName();
		return url;
	}

	/**
	 * 获取Http请求的完整路径，包括参数
	 *
	 * @param request
	 * @return
	 */
	public static String getFullURL(HttpServletRequest request) {
		String url = "";
		url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
		if (request.getQueryString() != null) {
			url += "?" + request.getQueryString();
		}
		return url;
	}

	/**
	 * 获取Http请求的完整路径，包括参数，不包括端口号
	 *
	 * @param request
	 * @return
	 */
	public static String getFullURLWithOutPort(HttpServletRequest request) {
		String url = "";
		url = request.getScheme() + "://" + request.getServerName() + request.getServletPath();
		if (request.getQueryString() != null) {
			url += "?" + request.getQueryString();
		}
		return url;
	}
}
