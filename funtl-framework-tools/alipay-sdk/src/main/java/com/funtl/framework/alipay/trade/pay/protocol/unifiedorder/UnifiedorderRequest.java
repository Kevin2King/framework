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

package com.funtl.framework.alipay.trade.pay.protocol.unifiedorder;

/**
 * 统一下单请求对象
 * <p>参考<a href="https://doc.open.alipay.com/docs/doc.htm?spm=a219a.7629140.0.0.Xh0Gbu&treeId=62&articleId=104743&docType=1">开发文档</p>
 * <p/>
 * Created by 金勇 on 2016-11-03.
 */
public class UnifiedorderRequest {
	private String service;
	private String partner;
	private String _input_charset = "utf-8";
	private String sign_type = "MD5";
	private String sign;
	private String notify_url;
	private String return_url;
	private String out_trade_no;
	private String subject;
	private String payment_type;
	private String total_fee;
	private String seller_id;
	private String seller_email;
	private String seller_account_name;
	private String buyer_id;
	private String buyer_email;
	private String buyer_account_name;
	private Double price;
	private Integer quantity;
	private String body;
	private String show_url;
	private String paymethod;
	private String enable_paymethod;
	private String anti_phishing_key;
	private String exter_invoke_ip;
	private String extra_common_param;
	private String it_b_pay;
	private String token;
	private String qr_pay_mode;
	private Integer qrcode_width;
	private String need_buyer_realnamed;
	private String hb_fq_param;
	private String goods_type;
	private String currency;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String get_input_charset() {
		return _input_charset;
	}

	public void set_input_charset(String _input_charset) {
		this._input_charset = _input_charset;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getSeller_email() {
		return seller_email;
	}

	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	public String getSeller_account_name() {
		return seller_account_name;
	}

	public void setSeller_account_name(String seller_account_name) {
		this.seller_account_name = seller_account_name;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getBuyer_email() {
		return buyer_email;
	}

	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}

	public String getBuyer_account_name() {
		return buyer_account_name;
	}

	public void setBuyer_account_name(String buyer_account_name) {
		this.buyer_account_name = buyer_account_name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getShow_url() {
		return show_url;
	}

	public void setShow_url(String show_url) {
		this.show_url = show_url;
	}

	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getEnable_paymethod() {
		return enable_paymethod;
	}

	public void setEnable_paymethod(String enable_paymethod) {
		this.enable_paymethod = enable_paymethod;
	}

	public String getAnti_phishing_key() {
		return anti_phishing_key;
	}

	public void setAnti_phishing_key(String anti_phishing_key) {
		this.anti_phishing_key = anti_phishing_key;
	}

	public String getExter_invoke_ip() {
		return exter_invoke_ip;
	}

	public void setExter_invoke_ip(String exter_invoke_ip) {
		this.exter_invoke_ip = exter_invoke_ip;
	}

	public String getExtra_common_param() {
		return extra_common_param;
	}

	public void setExtra_common_param(String extra_common_param) {
		this.extra_common_param = extra_common_param;
	}

	public String getIt_b_pay() {
		return it_b_pay;
	}

	public void setIt_b_pay(String it_b_pay) {
		this.it_b_pay = it_b_pay;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getQr_pay_mode() {
		return qr_pay_mode;
	}

	public void setQr_pay_mode(String qr_pay_mode) {
		this.qr_pay_mode = qr_pay_mode;
	}

	public Integer getQrcode_width() {
		return qrcode_width;
	}

	public void setQrcode_width(Integer qrcode_width) {
		this.qrcode_width = qrcode_width;
	}

	public String getNeed_buyer_realnamed() {
		return need_buyer_realnamed;
	}

	public void setNeed_buyer_realnamed(String need_buyer_realnamed) {
		this.need_buyer_realnamed = need_buyer_realnamed;
	}

	public String getHb_fq_param() {
		return hb_fq_param;
	}

	public void setHb_fq_param(String hb_fq_param) {
		this.hb_fq_param = hb_fq_param;
	}

	public String getGoods_type() {
		return goods_type;
	}

	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
