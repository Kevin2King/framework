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

package com.funtl.framework.tencent.wechat.menu;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.funtl.framework.tencent.wechat.exception.WeChatException;
import com.funtl.framework.tencent.wechat.lang.HttpUtils;
import com.funtl.framework.tencent.wechat.token.TokenProxy;
import com.funtl.framework.tencent.wechat.util.WeChatUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信菜单操作
 *
 * @author Zhangxs
 * @version 2015-7-4
 */
public class MenuManager {
	private static Logger logger = LoggerFactory.getLogger(MenuManager.class);

	private static final String MENU_CREATE_POST_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	private static final String MENU_GET_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
	private static final String MENU_DEL_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";

	private String accessToken;

	public MenuManager() {
		this.accessToken = TokenProxy.accessToken();
	}

	/**
	 * 创建菜单
	 *
	 * @throws WeChatException
	 */
	public void create(Menu menu) throws WeChatException {
		logger.info("创建菜单");
		String resultStr = HttpUtils.post(MENU_CREATE_POST_URL + this.accessToken, JSON.toJSONString(menu));
		WeChatUtil.isSuccess(resultStr);
	}

	/**
	 * 查询菜单
	 */
	public Menu getMenu() {
		logger.info("查询菜单");
		String resultStr = HttpUtils.get(MENU_GET_GET_URL + this.accessToken);
		try {
			WeChatUtil.isSuccess(resultStr);
		} catch (WeChatException e) {
			e.printStackTrace();
			return null;
		}
		JSONObject menuObject = JSONObject.parseObject(resultStr);
		Menu menu = menuObject.getObject("menu", Menu.class);
		return menu;
	}

	/**
	 * 删除菜单
	 *
	 * @throws WeChatException
	 */
	public void delete() throws WeChatException {
		logger.info("删除菜单");
		String resultStr = HttpUtils.get(MENU_DEL_GET_URL + this.accessToken);
		WeChatUtil.isSuccess(resultStr);
	}

}
