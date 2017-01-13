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

package com.funtl.framework.tencent.wechat.lang;

import java.util.Calendar;
import java.util.Date;

/**
 * @author ChengNing
 * @date 2014年10月30日
 */
public class DateTime extends Date {


	public static final DateTime MAX_DATE_TIME = new DateTime(9999, 12, 31, 23, 59, 59);
	public static final DateTime MIN_DATE_TIME = new DateTime(0001, 1, 1, 00, 00, 0);

	private static final long serialVersionUID = 1L;
	private Date date;
	private Calendar calendar;

	public DateTime(long ticks) {
		this.date = new Date(ticks);
	}

	public DateTime(int year, int month, int day) {
		calendar.set(year, month, day);
		this.date = calendar.getTime();
	}

	public DateTime(int year, int month, int day, int hour, int minute, int second) {
		calendar.set(year, month, day, hour, minute, second);
		this.date = calendar.getTime();
	}

	public DateTime(String dateString) {
		this.date = DateTimeUtil.getDate(dateString);
	}

	public String toString() {
		return DateTimeUtil.toDateTimeStr(this.date);
	}

	public String toString(String format) {
		return DateTimeUtil.toDateString(this.date, format);
	}

	public Date toDate() {
		return this.date;
	}


}
