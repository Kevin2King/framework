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

package com.funtl.framework.alipay.trade.pay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funtl.framework.alipay.trade.common.AlipayConfig;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api.AlipayClient;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.api.DefaultAlipayClient;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.request.AlipayDataDataserviceBillDownloadurlQueryRequest;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.util.ZipEntry;
import com.funtl.framework.alipay.trade.pay.protocol.downloadbill.util.ZipInputStream;
import com.funtl.framework.alipay.trade.pay.protocol.notify.PayResultNotifyResponse;
import com.funtl.framework.alipay.trade.pay.protocol.notify.PayResultReturnResponse;
import com.funtl.framework.alipay.trade.pay.protocol.unifiedorder.UnifiedorderRequest;
import com.funtl.framework.alipay.trade.util.AlipayNotify;
import com.funtl.framework.alipay.trade.util.AlipaySubmit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 金勇 on 2016-11-04.
 */
public class PayManager {
	private static final Logger logger = LoggerFactory.getLogger(PayManager.class);
	/**
	 * 支付宝提供给商户的服务接入网关URL(新)
	 */
	public static final String HTTPS_MAPI_ALIPAY_COM_GATEWAY_DO = "https://mapi.alipay.com/gateway.do";
	/**
	 * 开放网关
	 */
	public static final String HTTPS_OPENAPI_ALIPAY_COM_GATEWAY_DO = "https://openapi.alipay.com/gateway.do";
	/**
	 * 查询对账单下载地址
	 */
	public static final String ALIPAY_DATA_DATASERVICE_BILL_DOWNLOADURL_QUERY = "alipay.data.dataservice.bill.downloadurl.query ";
	/**
	 * WAP支付 service
	 */
	public static final String ALIPAY_WAP_CREATE_DIRECT_PAY_BY_USER = "alipay.wap.create.direct.pay.by.user";
	/**
	 * PC支付 service
	 */
	public static final String CREATE_DIRECT_PAY_BY_USER = "create_direct_pay_by_user";
	/**
	 * PC境外支付 service
	 */
	public static final String CREATE_FOREX_TRADE = "create_forex_trade";
	/**
	 * WAP 境外支付 service
	 */
	public static final String CREATE_FOREX_TRADE_WAP = "create_forex_trade_wap";

	/**
	 * 统一下单
	 * <p><a href="https://doc.open.alipay.com/docs/doc.htm?spm=a219a.7629140.0.0.Xh0Gbu&treeId=62&articleId=104743&docType=1">开发文档</p>
	 *
	 * @param request
	 * @return
	 */
	public static String unifiedorder(UnifiedorderRequest request, HttpServletResponse response) {
		Map<String, String> stringObjectMap = objectToMap(request);
		String result = AlipaySubmit.buildRequest(stringObjectMap, "get", "确认");
		try {
			PrintWriter out = response.getWriter();
			out.println(result);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * 封装支付结果同步跳转通知
	 * <b>注意：买家付款成功后,会跳到 return_url所在的页面,这个页面可以展示给客户看,这个页面只有付款成功才会跳转,并且只跳转一次.. </b>
	 * <p><a href="https://doc.open.alipay.com/docs/doc.htm?spm=a219a.7629140.0.0.Xh0Gbu&treeId=62&articleId=104743&docType=1">开发文档</p>
	 *
	 * @param servletRequest
	 * @return
	 */
	public static PayResultReturnResponse parsePayResultReturn(ServletRequest servletRequest) {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		//获取支付宝GET过来反馈信息
		Map<String, String> params = requestToMap(request);
		//计算得出通知验证结果
		boolean verify_result = AlipayNotify.verify(params);
		if (!verify_result) {
			throw new RuntimeException("验证失败");
		}
		PayResultReturnResponse payResultReturnResponse = (PayResultReturnResponse) mapToObject(params, PayResultReturnResponse.class);
		return payResultReturnResponse;

	}

	/**
	 * 封装支付结果服务器通知
	 * <b>注意：这个页面是支付宝服务器端自动调用这个页面的链接地址,
	 * 这个页面根据支付宝反馈过来的信息修改网站的定单状态,更新完成后需要返回一个success给支付宝.,
	 * 不能含有任何其它的字符包括html语言.
	 * </b>
	 * <p><a href="https://doc.open.alipay.com/docs/doc.htm?spm=a219a.7629140.0.0.Xh0Gbu&treeId=62&articleId=104743&docType=1">开发文档</p>
	 *
	 * @param servletRequest
	 * @param servletResponse
	 * @return
	 */
	public static PayResultNotifyResponse parsePayResultNotify(ServletRequest servletRequest, ServletResponse servletResponse) {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		//获取支付宝POST过来反馈信息
		Map<String, String> params = requestToMap(request);
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		if (AlipayNotify.verify(params)) {//验证成功
			return (PayResultNotifyResponse) mapToObject(params, PayResultNotifyResponse.class);
		} else {//验证失败
			return null;
		}
	}

	/**
	 * 下载对账单
	 * <p>参考<a href="https://doc.open.alipay.com/docs/api.htm?spm=a219a.7386797.0.0.fXCkuF&docType=4&apiId=1054">开发文档</p>
	 *
	 * @param billDate 下载对账单的日期，如果 billDate == null 下载两天前的对账单
	 * @return 放回对账单列表 和 汇总列表字符串  以 |####| 分隔
	 */
	public static AlipayDataDataserviceBillDownloadurlQueryResponse downloadbill(Date billDate) {
		Date currentDate = null;
		if (billDate != null) {
			currentDate = billDate;
		} else {
			currentDate = new Date();
		}
		String billDateStr = new SimpleDateFormat("yyyy-MM-dd").format(currentDate);
		AlipayClient alipayClient = new DefaultAlipayClient(HTTPS_OPENAPI_ALIPAY_COM_GATEWAY_DO, AlipayConfig.appId, AlipayConfig.rsaPrivateKey, "json");
		AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();
		request.setBizContent("{\"bill_type\":\"trade\",\"bill_date\":\"" + billDateStr + "\"}");
		try {
			AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(request);
			if (response.isSuccess()) {
				//调用成功，下载对账文件
				String urlStr = response.getBillDownloadUrl();
				try {
					//创建文件链接
					URL url = new URL(urlStr);
					HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
					//设置链接参数
					httpUrlConnection.setConnectTimeout(5 * 1000);
					httpUrlConnection.setDoInput(true);//打开输入输出流
					httpUrlConnection.setDoOutput(true);
					httpUrlConnection.setUseCaches(false);
					httpUrlConnection.setRequestMethod("GET");
					httpUrlConnection.setRequestProperty("Charsert", "UTF-8");
					httpUrlConnection.setRequestProperty("Connection", "Keep-Alive");
					//建立链接
					httpUrlConnection.connect();
					//获得输入流，文件为zip格式，
					InputStream fis = httpUrlConnection.getInputStream();
					ZipInputStream in = new ZipInputStream(fis);
					//不解压直接读取,加上gbk解决乱码问题
					BufferedReader br = new BufferedReader(new InputStreamReader(in, "gbk"));
					ZipEntry zipFile;
					//循环读取zip中的cvs文件，无法使用jdk自带，因为文件名中有中文
					StringBuffer lineStrSb = new StringBuffer();
					StringBuffer countStrSb = new StringBuffer();
					List<String> billDataList = new ArrayList<>();
					List<String> billCountDataList = new ArrayList<>();
					while ((zipFile = in.getNextEntry()) != null) {
						if (zipFile.isDirectory()) {
							//如果是目录，不处理
							continue;
						}
						//获得cvs名字
						String fileName = zipFile.getName();
						//检测文件是否存在
						if (fileName != null && fileName.indexOf(".") != -1) {
							String line;
							int beginLine = 0;
							boolean startLine = false;
							int beginCount = 0;
							boolean startCount = false;
							while ((line = br.readLine()) != null) {
								if (line.contains("业务明细列表")) {
									startLine = true;
								}
								if (line.contains("业务明细列表结束")) {
									startLine = false;
									beginLine = 0;
								}
								if (line.contains("业务汇总列表")) {
									startCount = true;
								}
								if (line.contains("业务汇总列表结束")) {
									startCount = false;
									beginCount = 0;
								}

								if (startLine) {
									beginLine++;
								}
								if (startCount) {
									beginCount++;
								}
								if (beginLine >= 2) {
									billDataList.add(line.replaceAll("\\t", ""));
									logger.debug("支付宝下载对账单：明细记录：" + line.replaceAll("\\t", ""));
								}
								if (beginCount >= 2) {
									billCountDataList.add(line.replaceAll("\\t", ""));
									logger.debug("支付宝下载对账单：汇总记录：" + line);
								}
							}
						}
					}
					//关闭流
					br.close();
					in.close();

					response.setBillDataList(billDataList);
					response.setBillCountDataList(billCountDataList);
					return response;
				} catch (Exception e) {
					logger.error("下载支付宝对账单,根据对账单地址获取对账单异常：", e);
				}
			} else {
				return response;
			}
		} catch (Exception e) {
			logger.error("下载支付宝对账单，发生错误:", e);
		}
		return null;
	}


	private static Map<String, String> requestToMap(HttpServletRequest request) {
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		return params;
	}

	private static Object mapToObject(Map<String, String> map, Class<?> beanClass) {
		try {
			if (map == null) return null;
			Object obj = beanClass.newInstance();
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				int mod = field.getModifiers();
				if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
					continue;
				}
				field.setAccessible(true);
				field.set(obj, map.get(field.getName()));
			}
			return obj;
		} catch (Exception e) {
			logger.error("Map转Object失败", e);
		}

		return null;
	}

	private static Map<String, String> objectToMap(Object obj) {
		if (obj == null) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		try {
			Field[] declaredFields = obj.getClass().getDeclaredFields();
			for (Field field : declaredFields) {
				field.setAccessible(true);
				Object o = field.get(obj);
				String typeName = field.getType().getTypeName();
				String value = null;
				if ("java.lang.Double".equals(typeName)) {
					if (o == null) {
						continue;
					}
					DecimalFormat df = new DecimalFormat("######0.00");
					value = df.format((Double) o);
				} else if ("java.lang.Integer".equals(typeName)) {
					if (o == null) {
						continue;
					}
					value = String.valueOf((Integer) o);
				} else {
					value = (String) o;
				}
				map.put(field.getName(), value);
			}
		} catch (Exception e) {
			logger.error("对象转Map出错", e);
		}
		return map;
	}
}
