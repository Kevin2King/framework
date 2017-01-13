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

package com.funtl.framework.tencent.wechat.event;

/**
 * 微信消息类型,大小写对应微信接口，msgType的枚举值
 *
 * @author ChengNing
 * @date 2014-12-4
 */
public enum MsgType {
	event,        //事件
	text,         //文本消息
	image, location, link, voice, video, shortvideo,      //小视频消息
	music, news, transfer_customer_service;//客服系统
}
