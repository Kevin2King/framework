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

import com.funtl.framework.tencent.wechat.token.server.AccessTokenServer;
import com.funtl.framework.tencent.wechat.token.server.JsApiTicketServer;
import com.funtl.framework.tencent.wechat.token.server.TicketServer;
import com.funtl.framework.tencent.wechat.token.server.TokenServer;

/**
 * AccessToken代理
 * 所有获取accessToken的地方都通过此代理获得
 * 获得方法String token = AccessTokenProxy.token()
 *
 * @author ChengNing
 * @date 2015年1月9日
 */
public class TokenProxy {

	/**
	 * 通过代理得到accessToken的串
	 */
	public static String accessToken() {
		TokenServer accessTokenServer = new AccessTokenServer();
		return accessTokenServer.token();
	}

	/**
	 * 通过代理得到jsapi_ticket
	 */
	public static String jsApiTicket() {
		TicketServer ticketServer = new JsApiTicketServer();
		return ticketServer.ticket();
	}


}
