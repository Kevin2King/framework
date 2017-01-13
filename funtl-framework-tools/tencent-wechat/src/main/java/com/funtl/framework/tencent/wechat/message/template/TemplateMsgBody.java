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

package com.funtl.framework.tencent.wechat.message.template;

import java.util.List;


/**
 * @author ChengNing
 * @date 2014年12月24日
 */
public class TemplateMsgBody {
	private String touser;
	private String templateId;
	private String url;
	private String topcolor;
	//	private TemplateMsgData first;
	//	private TemplateMsgData remark;
	//	private List<TemplateMsgData> keynote;
	private List<TemplateMsgData> data;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTopcolor() {
		return topcolor;
	}

	public void setTopcolor(String topcolor) {
		this.topcolor = topcolor;
	}

	//	public TemplateMsgData getFirst() {
	//		return first;
	//	}
	//	public void setFirst(TemplateMsgData first) {
	//		this.first = first;
	//	}
	//	public TemplateMsgData getRemark() {
	//		return remark;
	//	}
	//	public void setRemark(TemplateMsgData remark) {
	//		this.remark = remark;
	//	}
	//	public List<TemplateMsgData> getKeynote() {
	//		return keynote;
	//	}
	//	public void setKeynote(List<TemplateMsgData> keynote) {
	//		this.keynote = keynote;
	//	}
	public List<TemplateMsgData> getData() {
		return data;
	}

	public void setData(List<TemplateMsgData> data) {
		this.data = data;
	}


}
