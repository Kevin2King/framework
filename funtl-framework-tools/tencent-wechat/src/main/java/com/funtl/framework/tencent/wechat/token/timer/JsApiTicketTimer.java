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

package com.funtl.framework.tencent.wechat.token.timer;

import java.util.TimerTask;

import com.funtl.framework.tencent.wechat.token.Ticket;
import com.funtl.framework.tencent.wechat.token.TicketType;
import com.funtl.framework.tencent.wechat.token.server.CustomerServer;
import com.funtl.framework.tencent.wechat.token.server.JsApiTicketServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ChengNing
 * @date 2015年1月29日
 */
public class JsApiTicketTimer extends TimerTask {

	private static Logger logger = LoggerFactory.getLogger(JsApiTicketTimer.class);
	// jsapi_ticket有效期7200秒,提前200秒请求新的token
	public static final long PERIOD = 7000 * 1000;
	public static final long DELAY = 0; // 此任务的延迟时间为0，即立即执行

	@Override
	public void run() {
		logger.info("jsapi_ticket 定时任务启动，获取新的jsapi_ticket");
		// 得到新的access token
		Ticket jsapiTicket = new Ticket(TicketType.jsapi);
		// 手动获取成功之后持久化accessToken
		if (jsapiTicket.request()) {
			JsApiTicketServer jsapiTicketServer = new JsApiTicketServer();
			CustomerServer customerServer = (CustomerServer) jsapiTicketServer.customerServer();
			customerServer.save(jsapiTicket);
		}
	}

}
