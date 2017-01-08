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

/*
 *
 *   @copyright 		Copyright © 2016 - 2020. [相关部门] All rights reserved.
 *   @project   		script - funtl-framework-core-commons
 *   @file      		StyleUtils
 *   @author    		warne
 *   @date      		16-12-10 下午2:24
 *
 *   @lastModifie 		16-12-10 下午2:24
 *
 */
package com.funtl.framework.core.style;

import com.funtl.framework.core.utils.StringUtils;

/**
 * Created by warne on 2016/12/10.
 * DESC: word brother 666
 */
public abstract class StyleUtils {

	private final static String YES = "<i class='fa fa-check-circle font-green'></i>";
	private final static String NO = "<i class='fa fa-circle font-red-pink'></i>";
	private final static String YES_LABEL = "<span class='font-green' style='font-size: 12px;'><i class='fa fa-check-circle'></i> 是</span>";
	private final static String NO_LABEL = "<span class='font-red-pink' style='font-size: 12px;'><i class='fa fa-check-circle'></i> 否</span>";
	private final static String OPEN = "<span class='font-green' style='font-size: 12px;'><i class='fa fa-check-circle font-green'></i> 开启中</span>";
	private final static String CLOSE = "<span class='font-grey-salsa' style='font-size: 12px;'><i class='fa fa-ban'></i> 关闭中</span>";
	private final static String ERROR = "<span class='font-red-mint' style='font-size: 12px;'><i class='fa fa-warning'></i></span>";


	/***
	 * 是 否
	 * 图标显示样式
	 * @param yesOrNo
	 * @return
	 */
	public static String yesOrNoIcon(String yesOrNo) {
		if (StringUtils.isBlank(yesOrNo)) return ERROR;
		if ("1".equalsIgnoreCase(yesOrNo)) return YES;
		if ("0".equalsIgnoreCase(yesOrNo)) return NO;
		else return ERROR;
	}

	/***
	 * 开启  关闭
	 * 图标显示样式
	 * @param openOrClose
	 * @return
	 */
	public static String openOrCloseIcon(String openOrClose) {
		if (StringUtils.isBlank(openOrClose)) return ERROR;
		if ("1".equalsIgnoreCase(openOrClose)) return OPEN;
		if ("0".equalsIgnoreCase(openOrClose)) return CLOSE;
		else return ERROR;
	}

	/***
	 * 是 否
	 * 图标显示样式 带label
	 * @param yesOrNo
	 * @return
	 */
	public static String yesOrNoIconWithLabel(String yesOrNo) {
		if (StringUtils.isBlank(yesOrNo)) return ERROR;
		if ("1".equalsIgnoreCase(yesOrNo)) return YES_LABEL;
		if ("0".equalsIgnoreCase(yesOrNo)) return NO_LABEL;
		else return ERROR;
	}

}
