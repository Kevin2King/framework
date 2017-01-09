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

package com.funtl.framework.paypal.base.util;

import java.io.UnsupportedEncodingException;


public final class PayPalURLEncoder {
	static final String DIGITS = "0123456789abcdef";

	/**
	 * Prevents this class from being instantiated.
	 */
	private PayPalURLEncoder() {
	}

	/**
	 * Encodes the given string {@code s} in a x-www-form-urlencoded string
	 * using the specified encoding scheme {@code enc}.
	 * <p>
	 * All characters except letters ('a'..'z', 'A'..'Z') and numbers ('0'..'9')
	 * and characters  '_' are converted into their hexadecimal
	 * value prepended by '%'. For example: '#' -> %23. In addition, spaces are
	 * substituted by '+'
	 *
	 * @param s   the string to be encoded.
	 * @param enc the encoding scheme to be used.
	 * @return the encoded string.
	 */

	public static String encode(String s, String enc) throws UnsupportedEncodingException {
		if (s == null || enc == null) {
			throw new NullPointerException();
		}


		// Guess a bit bigger for encoded form
		StringBuffer buf = new StringBuffer(s.length() + 16);
		int start = -1;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') || " _".indexOf(ch) > -1) { //removed "." and "-" and "*"

				if (start >= 0) {
					convert(s.substring(start, i), buf, enc);
					start = -1;
				}
				if (ch != ' ') {
					buf.append(ch);
				} else {
					buf.append('+');
				}
			} else {
				if (start < 0) {
					start = i;
				}
			}
		}
		if (start >= 0) {
			convert(s.substring(start, s.length()), buf, enc);
		}

		return buf.toString();
	}


	private static void convert(String s, StringBuffer buf, String enc) throws UnsupportedEncodingException {
		byte[] bytes = s.getBytes(enc);
		for (int j = 0; j < bytes.length; j++) {
			buf.append('%');
			buf.append(DIGITS.charAt((bytes[j] & 0xf0) >> 4));
			buf.append(DIGITS.charAt(bytes[j] & 0xf));
		}
	}
}
