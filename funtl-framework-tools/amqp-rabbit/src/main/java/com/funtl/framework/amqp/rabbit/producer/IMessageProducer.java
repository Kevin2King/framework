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

package com.funtl.framework.amqp.rabbit.producer;

/**
 * 消息生产者
 * Created by 李卫民 on 2016/8/2.
 */
public interface IMessageProducer {
	/**
	 * 发送消息到指定队列
	 *
	 * @param queueKey
	 * @param message
	 */
	public void sendDataToQueue(String queueKey, Object message);
}
