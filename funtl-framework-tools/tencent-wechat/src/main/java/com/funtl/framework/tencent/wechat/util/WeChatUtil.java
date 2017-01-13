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

package com.funtl.framework.tencent.wechat.util;

import com.alibaba.fastjson.JSONObject;
import com.funtl.framework.tencent.wechat.exception.WeChatException;
import com.funtl.framework.tencent.wechat.exception.WeChatReturnCode;

/**
 * 工具类
 *
 * @author Zhangxs
 * @version 2015-7-4
 */
public class WeChatUtil {
	/**
	 * 判断是否请求成功
	 *
	 * @param resultStr
	 * @throws WeChatException
	 */
	public static void isSuccess(String resultStr) throws WeChatException {
		JSONObject jsonObject = JSONObject.parseObject(resultStr);
		Integer errCode = jsonObject.getIntValue("errcode");
		if (errCode != null && errCode != 0) {
			String errMsg = WeChatReturnCode.getMsg(errCode);
			if (errMsg.equals("")) {
				errMsg = jsonObject.getString("errmsg");
			}
			throw new WeChatException("异常码:" + errCode + ";异常说明:" + errMsg);
		}
	}
}
