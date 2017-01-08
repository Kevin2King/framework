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

package com.funtl.framework.core.dto;

import java.io.Serializable;

import com.funtl.framework.core.mapper.JsonMapper;

/**
 * ajax 请求的返回类型封装JSON结果
 * Created by Lusifer on 2016/7/25.
 */
@SuppressWarnings("unchecked")
public class BaseResult<T> implements Serializable {
	private boolean success;
	private T data;
	private String error;

	/**
	 * 无参构造函数，用于Jackson解析
	 */
	public BaseResult() {

	}

	public BaseResult(boolean success, String error) {
		this.success = success;
		this.error = error;
	}

	public BaseResult(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "BaseResult [success=" + success + ", data=" + data + ", error=" + error + "]";
	}

	// -------------------------------------------------------------------- 通用返回结果开始 --------------------------------------------------------------------

	//# 公共常量
	static boolean TRUE = true;//# 成功
	static boolean FALSE = false;//# 失败
	static String SUCCESS = "SUCCESS";//# 成功
	static String FAIL = "FAIL";//# 失败

	/**
	 * 请求成功
	 *
	 * @param data 传输数据
	 * @return
	 */
	public static String responseSuccess(Object data) {
		BaseResult result = new BaseResult();
		result.setData(data);
		result.setError(SUCCESS);
		result.setSuccess(TRUE);

		return JsonMapper.toJsonString(result);
	}

	/**
	 * 请求失败 - 无提示
	 *
	 * @return
	 */
	public static String responseFail() {
		BaseResult result = new BaseResult();
		result.setSuccess(FALSE);
		result.setData(null);
		result.setError(FAIL);

		return JsonMapper.toJsonString(result);
	}

	/**
	 * 请求失败 - 带提示
	 *
	 * @param msg
	 * @return
	 */
	public static String responseFail(String msg) {
		BaseResult result = new BaseResult();
		result.setData(null);
		result.setSuccess(FALSE);
		result.setError(msg);

		return JsonMapper.toJsonString(result);
	}

	/**
	 * 请求失败 - 自定义
	 *
	 * @param result
	 * @return
	 */
	public static String responseFail(BaseResult result) {
		return JsonMapper.toJsonString(result);
	}

	// -------------------------------------------------------------------- 通用返回结果结束 --------------------------------------------------------------------
}
