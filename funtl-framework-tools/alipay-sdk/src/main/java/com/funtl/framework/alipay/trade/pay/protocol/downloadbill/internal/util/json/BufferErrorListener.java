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

package com.funtl.framework.alipay.trade.pay.protocol.downloadbill.internal.util.json;

public class BufferErrorListener implements JSONErrorListener {

	protected StringBuffer buffer;
	private String input;

	public BufferErrorListener(StringBuffer buffer) {
		this.buffer = buffer;
	}

	public BufferErrorListener() {
		this(new StringBuffer());
	}

	public void start(String input) {
		this.input = input;
		buffer.setLength(0);
	}

	public void error(String type, int col) {
		buffer.append("expected ");
		buffer.append(type);
		buffer.append(" at column ");
		buffer.append(col);
		buffer.append("\n");
		buffer.append(input);
		buffer.append("\n");
		indent(col - 1, buffer);
		buffer.append("^");
	}

	private void indent(int n, StringBuffer ret) {
		for (int i = 0; i < n; ++i) {
			ret.append(' ');
		}
	}

	public void end() {
	}
}
