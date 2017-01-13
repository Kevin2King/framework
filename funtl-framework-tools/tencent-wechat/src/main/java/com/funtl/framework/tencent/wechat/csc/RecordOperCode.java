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

package com.funtl.framework.tencent.wechat.csc;

import java.util.HashMap;
import java.util.Map;

/**
 * 操作ID(会话状态)说明
 *
 * @author Zhangxs
 * @date 2015-7-8
 */
public class RecordOperCode {
	private final static Map<Integer, String> operCodeMap = new HashMap<Integer, String>();

	static {
		operCodeMap.put(1000, "创建未接入会话");
		operCodeMap.put(1001, "接入会话");
		operCodeMap.put(1002, "主动发起会话");
		operCodeMap.put(1004, "关闭会话");
		operCodeMap.put(1005, "抢接会话");
		operCodeMap.put(2001, "公众号收到消息");
		operCodeMap.put(2002, "客服发送消息");
		operCodeMap.put(2003, "客服收到消息");
	}

	/**
	 * 根据opercode返回会话状态
	 *
	 * @param opercode
	 * @return
	 */
	public static String getSessionState(int opercode) {
		if (operCodeMap.containsKey(opercode)) {
			return operCodeMap.get(opercode);
		}
		return "";
	}
}
