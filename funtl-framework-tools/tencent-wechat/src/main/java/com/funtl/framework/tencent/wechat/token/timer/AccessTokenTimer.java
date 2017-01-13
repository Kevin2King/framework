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

import com.funtl.framework.tencent.wechat.token.AccessToken;
import com.funtl.framework.tencent.wechat.token.server.AccessTokenServer;
import com.funtl.framework.tencent.wechat.token.server.CustomerServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * access token 定时器
 *
 * @author ChengNing
 * @date 2015年1月8日
 */
public class AccessTokenTimer extends TimerTask {

	private static Logger logger = LoggerFactory.getLogger(AccessTokenTimer.class);

	//accessToken有效期7200秒,提前200秒请求新的token
	public static final long PERIOD = 7000 * 1000;
	public static final long DELAY = 0; //此任务的延迟时间为0，即立即执行

	@Override
	public void run() {
		logger.info("accessToken 定时任务启动，获取新的accessToken");
		//得到新的access token
		AccessToken accessToken = new AccessToken();
		//获取成功之后持久化accessToken
		if (accessToken.request()) {
			AccessTokenServer accessTokenServer = new AccessTokenServer();
			CustomerServer customerServer = (CustomerServer) accessTokenServer.customerServer();
			customerServer.save(accessToken);
		}
	}

}
