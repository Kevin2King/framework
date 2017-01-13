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

package com.funtl.framework.tencent.wechat.token;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.funtl.framework.tencent.wechat.token.timer.AccessTokenTimer;
import com.funtl.framework.tencent.wechat.token.timer.JsApiTicketTimer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Access Token 监听器
 *
 * @author ChengNing
 * @date 2015年1月8日
 */
public class TokenListener implements ServletContextListener {

	private static Logger logger = LoggerFactory.getLogger(TokenListener.class);

	private Timer timer = null;

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("accessToken监听器启动..........");
		timer = new Timer(true);
		//注册定时任务
		registeAccessTokenTimer();
		//注册jsapi_ticket定时器
		registeJsApiTicketTimer();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		timer.cancel();
	}

	/**
	 * 注册accessToken定时器
	 */
	private void registeAccessTokenTimer() {
		AccessTokenTimer accessTokenTimer = new AccessTokenTimer();
		timer.schedule(accessTokenTimer, AccessTokenTimer.DELAY, AccessTokenTimer.PERIOD);
		logger.info("accessToken定时器注册成功，执行间隔为" + AccessTokenTimer.PERIOD);
	}

	/**
	 * 注册jsapi_ticket定时器
	 */
	private void registeJsApiTicketTimer() {
		JsApiTicketTimer jsApiTicketTimer = new JsApiTicketTimer();
		timer.schedule(jsApiTicketTimer, JsApiTicketTimer.DELAY, JsApiTicketTimer.PERIOD);
	}

}
