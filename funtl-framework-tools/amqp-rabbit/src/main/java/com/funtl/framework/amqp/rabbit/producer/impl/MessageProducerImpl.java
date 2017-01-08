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

package com.funtl.framework.amqp.rabbit.producer.impl;

import com.funtl.framework.amqp.rabbit.producer.IMessageProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能概要：消息产生,提交到队列中去
 * Created by 李卫民 on 2016/8/2.
 */
@Service
public class MessageProducerImpl implements IMessageProducer {
	private static final Logger logger = LoggerFactory.getLogger(MessageProducerImpl.class);

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Override
	public void sendDataToQueue(String queueKey, Object message) {
		// convertAndSend：
		// 将Java对象转换为消息发送到匹配Key的交换机中Exchange，由于配置了JSON转换，这里是将Java对象转换成JSON字符串的形式
		try {
			logger.info("to send message:{}", message);
			amqpTemplate.convertAndSend(queueKey, message);
		} catch (AmqpException e) {
			logger.error(e.getMessage());
		}
	}
}
