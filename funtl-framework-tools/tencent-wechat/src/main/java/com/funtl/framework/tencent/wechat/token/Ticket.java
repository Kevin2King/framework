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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 微信ticket操作类
 * ticket和token的逻辑在腾讯是差不多的，所以继承抽象类token
 *
 * @author ChengNing
 * @date 2015年1月29日
 */
public class Ticket extends Token {

	private static Logger logger = LoggerFactory.getLogger(Ticket.class);

	private static final String TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?";
	private static final String TICKET_NAME = "ticket";
	private static final String EXPIRESIN_NAME = "expires_in";

	private String type;

	public Ticket(TicketType ticketType) {
		super();
		this.type = ticketType.name();
	}

	/* (non-Javadoc)
	 * @see org.sword.wechat4j.token.Token#accessTokenUrl()
	 */
	@Override
	protected String accessTokenUrl() {
		String access_token = TokenProxy.accessToken();
		String url = TICKET_URL + "access_token=" + access_token + "&type=" + this.type;
		logger.info("获取ticket,ticket类型" + this.type);
		return url;
	}

	/* (non-Javadoc)
	 * @see org.sword.wechat4j.token.Token#tokenName()
	 */
	@Override
	protected String tokenName() {
		return TICKET_NAME;
	}

	/* (non-Javadoc)
	 * @see org.sword.wechat4j.token.Token#expiresInName()
	 */
	@Override
	protected String expiresInName() {
		return EXPIRESIN_NAME;
	}


}
