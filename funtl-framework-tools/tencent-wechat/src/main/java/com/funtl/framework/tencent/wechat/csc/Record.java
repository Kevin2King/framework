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

/**
 * 聊天记录
 *
 * @author Zhangxs
 * @date 2015-7-7
 */
public class Record {

	private String openid;//用户的标识
	private int opercode;//操作ID(会话状态)
	private String text;//聊天记录
	private int time;//操作时间，UNIX时间戳
	private String worker;//客服账号

	public Record() {
		super();
	}

	public Record(String openid, int opercode, String text, int time, String worker) {
		super();
		this.openid = openid;
		this.opercode = opercode;
		this.text = text;
		this.time = time;
		this.worker = worker;
	}

	/**
	 * 用户的标识
	 *
	 * @return
	 */
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 操作ID(会话状态)
	 *
	 * @see RecordOperCode#getSessionState(int)
	 */
	public int getOpercode() {
		return opercode;
	}

	public void setOpercode(int opercode) {
		this.opercode = opercode;
	}

	/**
	 * 聊天记录
	 *
	 * @return
	 */
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 操作时间,UNIX时间戳
	 *
	 * @return
	 */
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * 客服账号
	 *
	 * @return
	 */
	public String getWorker() {
		return worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}

}
