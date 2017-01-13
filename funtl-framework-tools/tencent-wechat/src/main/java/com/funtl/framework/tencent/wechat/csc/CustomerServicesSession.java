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

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 会话状态
 *
 * @author Zhangxs
 * @date 2015-7-8
 */
public class CustomerServicesSession {

	private int createTime;//会话接入的时间
	private String kfAccount;//客服
	private String openId;//客户openid

	/**
	 * 会话接入的时间
	 *
	 * @return
	 */
	@JSONField(name = "createtime")
	public int getCreateTime() {
		return createTime;
	}

	@JSONField(name = "createtime")
	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	/**
	 * 客服
	 *
	 * @return
	 */
	@JSONField(name = "kf_account")
	public String getKfAccount() {
		return kfAccount;
	}

	@JSONField(name = "kf_account")
	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}

	/**
	 * 客户openid
	 *
	 * @return
	 */
	@JSONField(name = "openid")
	public String getOpenId() {
		return openId;
	}

	@JSONField(name = "openid")
	public void setOpenId(String openId) {
		this.openId = openId;
	}


}
