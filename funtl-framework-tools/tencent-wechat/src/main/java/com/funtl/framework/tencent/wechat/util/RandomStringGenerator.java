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

package com.funtl.framework.tencent.wechat.util;

import java.util.Random;

/**
 * 随机字符串生成器
 */
public class RandomStringGenerator {

	private static final int defaultLength = 32;
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";

	/**
	 * 获取一定长度的随机字符串
	 *
	 * @param length 指定字符串长度
	 * @return 一定长度的字符串
	 */
	public static String generate(int length) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(CHARACTERS.length());
			sb.append(CHARACTERS.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 获取默认长度的随机字符串
	 *
	 * @return 默认长度的字符串
	 */
	public static String generate() {
		return generate(defaultLength);
	}

}
