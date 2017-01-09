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

package com.funtl.framework.track.kdniao.electron.unifiedorder.request;

/**
 * Created by 金勇 on 2016-12-02.
 */
public class Commodity {
	/**
	 * 商品名称	R
	 */
	private String goodsName;
	/**
	 * 商品编码	O
	 */
	private String goodsCode;
	/**
	 * 商品数量	O
	 */
	private Integer goodsquantity;
	/**
	 * 商品价格	O
	 */
	private Double goodsPrice;
	/**
	 * 商品重量kg	O
	 */
	private Double goodsWeight;
	/**
	 * 商品描述	O
	 */
	private String goodsDesc;
	/**
	 * 商品体积m3	O
	 */
	private Double goodsVol;

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public Integer getGoodsquantity() {
		return goodsquantity;
	}

	public void setGoodsquantity(Integer goodsquantity) {
		this.goodsquantity = goodsquantity;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Double getGoodsWeight() {
		return goodsWeight;
	}

	public void setGoodsWeight(Double goodsWeight) {
		this.goodsWeight = goodsWeight;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public Double getGoodsVol() {
		return goodsVol;
	}

	public void setGoodsVol(Double goodsVol) {
		this.goodsVol = goodsVol;
	}
}
