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

package com.funtl.framework.apache.httpclient.meta.http;

import com.funtl.framework.apache.httpclient.meta.Bean;

import org.apache.http.HttpStatus;

public class HttpResult implements Bean {

	private String result;

	private int code = HttpStatus.SC_OK;

	private String errmsg;

	public HttpResult(int code, String result, String errmsg) {
		this.code = code;
		this.result = result;
		this.errmsg = errmsg;
	}

	public HttpResult(int code) {
		this.code = code;
	}

	public HttpResult(String result) {
		this.result = result;
	}

	public HttpResult(int code, String errmsg) {
		this.code = code;
		this.errmsg = errmsg;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return HttpStatus.SC_OK == this.code;
	}
}
