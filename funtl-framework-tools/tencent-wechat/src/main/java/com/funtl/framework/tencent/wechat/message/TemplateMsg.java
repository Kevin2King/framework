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

package com.funtl.framework.tencent.wechat.message;

import com.alibaba.fastjson.JSONObject;
import com.funtl.framework.tencent.wechat.lang.HttpUtils;
import com.funtl.framework.tencent.wechat.message.template.TemplateMsgBody;
import com.funtl.framework.tencent.wechat.message.template.TemplateMsgData;
import com.funtl.framework.tencent.wechat.token.TokenProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 模板消息接口
 *
 * @author ChengNing
 * @date 2014年12月24日
 */
public class TemplateMsg {

	private static Logger logger = LoggerFactory.getLogger(TemplateMsg.class);

	//设置所属行业接口地址
	public static final String SET_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=";
	//添加模板id接口地址
	public static final String GET_TEMPLATE_ID_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=";
	//发送模板消息接口地址
	public static final String SEND_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";

	private String accessToken;

	public TemplateMsg() {
		this.accessToken = TokenProxy.accessToken();
	}

	/**
	 * 设置所属行业
	 * 接口说明中没有给出
	 */
	public void setIndustry(String... industrys) {
		String url = SET_INDUSTRY_URL + this.accessToken;
		JSONObject json = new JSONObject();
		for (int i = 0; i < industrys.length; i++) {
			json.put("industry_id" + i, industrys[i]);
		}
		String data = json.toJSONString();
		HttpUtils.post(url, data);
	}

	/**
	 * 获得模板ID
	 *
	 * @param templateIdShort template_id_short
	 * @return template_id
	 */
	public String getTemplateId(String templateIdShort) {
		logger.info("get template id,short template id is:" + templateIdShort);
		//构造请求数据
		String url = GET_TEMPLATE_ID_URL + this.accessToken;
		JSONObject json = new JSONObject();
		json.put("template_id_short", templateIdShort);
		String data = json.toJSONString();
		String result = HttpUtils.post(url, data);
		logger.info("post result:" + result);
		//解析请求数据
		JSONObject resultJson = JSONObject.parseObject(result);
		if (resultJson.getString("errcode").equals("0")) return resultJson.getString("template_id");
		logger.error("get template id error:" + resultJson.getString("errmsg"));
		return null;
	}

	/**
	 * 发送模板消息
	 */
	public String send(TemplateMsgBody postData) {
		logger.info("send template message");
		//构造请求数据
		String url = SEND_MSG_URL + this.accessToken;
		JSONObject json = new JSONObject();
		json.put("touser", postData.getTouser());
		json.put("template_id", postData.getTemplateId());
		json.put("url", postData.getUrl());
		json.put("topcolor", postData.getTopcolor());
		JSONObject jsonData = new JSONObject();
		for (TemplateMsgData data : postData.getData()) {
			JSONObject keynote = new JSONObject();
			keynote.put("value", data.getValue());
			keynote.put("color", data.getColor());
			jsonData.put(data.getName(), keynote);
		}
		json.put("data", jsonData);

		String data = json.toJSONString();
		String result = HttpUtils.post(url, data);
		logger.info("post result:" + result);
		//解析请求数据
		JSONObject resultJson = JSONObject.parseObject(result);
		if (resultJson.getString("errcode").equals("0")) return resultJson.getString("msgid");

		logger.error("send template message error:" + resultJson.getString("errmsg"));
		return null;
	}


}
