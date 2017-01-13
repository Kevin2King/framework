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

package com.funtl.framework.tencent.wechat.lang;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ChengNing
 * @date 2014年12月7日
 */
public class JaxbParser {

	private static Logger logger = LoggerFactory.getLogger(JaxbParser.class);

	private Class clazz;
	private String[] cdataNode;

	/**
	 * @param clazz
	 */
	public JaxbParser(Class clazz) {
		this.clazz = clazz;
	}

	/**
	 * 设置需要包含CDATA的节点
	 *
	 * @param cdataNode
	 */
	public void setCdataNode(String[] cdataNode) {
		this.cdataNode = cdataNode;
	}

	/**
	 * 转为xml串
	 *
	 * @param obj
	 * @return
	 */
	public String toXML(Object obj) {
		String result = null;
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_FRAGMENT, true);// 去掉报文头
			OutputStream os = new ByteArrayOutputStream();
			XMLSerializer serializer = getXMLSerializer(os);
			m.marshal(obj, serializer.asContentHandler());
			result = os.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("response text:" + result);
		return result;
	}


	/**
	 * 转为对象
	 *
	 * @param is
	 * @return
	 */
	public Object toObj(InputStream is) {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(clazz);
			Unmarshaller um = context.createUnmarshaller();
			Object obj = um.unmarshal(is);
			return obj;
		} catch (Exception e) {
			logger.error("post data parse error");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * XML转为对象
	 *
	 * @param xmlStr
	 * @return
	 */
	public Object toObj(String xmlStr) {
		InputStream is = new ByteArrayInputStream(xmlStr.getBytes());
		return toObj(is);
	}

	/**
	 * 设置属性
	 *
	 * @param os
	 * @return
	 */
	private XMLSerializer getXMLSerializer(OutputStream os) {
		OutputFormat of = new OutputFormat();
		formatCDataTag();
		of.setCDataElements(cdataNode);
		of.setPreserveSpace(true);
		of.setIndenting(true);
		of.setOmitXMLDeclaration(true);
		XMLSerializer serializer = new XMLSerializer(of);
		serializer.setOutputByteStream(os);
		return serializer;
	}

	/**
	 * 适配cdata tag
	 */
	private void formatCDataTag() {
		for (int i = 0; i < cdataNode.length; i++) {
			cdataNode[i] = "^" + cdataNode[i];
		}
	}
}
