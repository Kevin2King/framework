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

package com.funtl.framework.tencent.wechat.request;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author ChengNing
 * @date 2015年1月7日
 */
public class ScanCodeInfo {
	private String ScanType;   //扫描类型，一般是qrcode
	private String ScanResult; //扫描结果，即二维码对应的字符串信息

	@XmlElement(name = "ScanType")
	public String getScanType() {
		return ScanType;
	}

	public void setScanType(String scanType) {
		ScanType = scanType;
	}

	@XmlElement(name = "ScanResult")
	public String getScanResult() {
		return ScanResult;
	}

	public void setScanResult(String scanResult) {
		ScanResult = scanResult;
	}


}
