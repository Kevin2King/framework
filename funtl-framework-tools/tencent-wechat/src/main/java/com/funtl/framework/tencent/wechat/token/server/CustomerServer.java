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

package com.funtl.framework.tencent.wechat.token.server;

import com.funtl.framework.tencent.wechat.token.Token;

/**
 * @author ChengNing
 * @date 2015年1月30日
 */
public abstract class CustomerServer implements IServer {

	public String token() {
		return find();
	}

	/**
	 * 保存或者更新accesstoken到数据库
	 * 由客户自己实现数据库插入或者更新操作
	 *
	 * @param token 得到的token或者ticket，需要保存
	 * @return
	 */
	public abstract boolean save(Token token);

	/**
	 * 从数据库得到accessToken
	 * 由客户自己实现数据库的查询操作
	 *
	 * @return
	 */
	protected abstract String find();

}
