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

package com.funtl.framework.tencent.wechat.user;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 关注者集合
 *
 * @author Zhangxs
 * @version 2015-7-5
 */
public class Follwers {
	private int total;//	关注该公众账号的总用户数
	private int count;//	拉取的OPENID个数，最大值为10000
	private Data data;//	列表数据，OPENID的列表
	private String nextOpenid;//拉取列表的后一个用户的OPENID

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@JSONField(name = "next_openid")
	public String getNextOpenid() {
		return nextOpenid;
	}

	@JSONField(name = "next_openid")
	public void setNextOpenid(String nextOpenid) {
		this.nextOpenid = nextOpenid;
	}

}

