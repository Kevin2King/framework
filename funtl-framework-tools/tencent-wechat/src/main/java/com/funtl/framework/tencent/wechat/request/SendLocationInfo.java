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
public class SendLocationInfo {
	private String Location_X;
	private String Location_Y;
	private String Scale;
	private String Label;
	private String Poiname;

	@XmlElement(name = "Location_X")
	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	@XmlElement(name = "Location_Y")
	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	@XmlElement(name = "Scale")
	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	@XmlElement(name = "Label")
	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	@XmlElement(name = "Poiname")
	public String getPoiname() {
		return Poiname;
	}

	public void setPoiname(String poiname) {
		Poiname = poiname;
	}


}
