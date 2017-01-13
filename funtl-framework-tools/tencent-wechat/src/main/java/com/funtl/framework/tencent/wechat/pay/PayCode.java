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

package com.funtl.framework.tencent.wechat.pay;

/**
 * 支付的结果
 * 对应以下2项返回数据
 * return_code
 * result_code
 * <p/>
 * Created by xuwen on 2015-12-13.
 */
public enum PayCode {

	SUCCESS, FAIL;

	public boolean equals(String payCode) {
		return this.toString().equals(payCode);
	}

}
