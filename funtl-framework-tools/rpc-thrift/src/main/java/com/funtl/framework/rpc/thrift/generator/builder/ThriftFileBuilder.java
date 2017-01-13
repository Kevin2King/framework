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

package com.funtl.framework.rpc.thrift.generator.builder;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.funtl.framework.rpc.thrift.generator.ThriftEnum;
import com.funtl.framework.rpc.thrift.generator.ThriftService;
import com.funtl.framework.rpc.thrift.generator.ThriftStruct;
import com.funtl.framework.rpc.thrift.generator.utils.CommonUtils;

/**
 * @author hongliuliao
 *         <p>
 *         createTime:2012-11-23 上午11:33:35
 */
public class ThriftFileBuilder {

	public String getPackageName(Class<?> commonServiceClass) {
		String packageName = commonServiceClass.getPackage().getName();
		String thriftPackage = packageName + ".iface";
		return thriftPackage;
	}

	public void buildToOutputStream(Class<?> commonServiceClass, OutputStream os) throws Exception {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		cfg.setClassForTemplateLoading(ThriftFileBuilder.class, "/");
		Template template = cfg.getTemplate("templates/thrift/thrift.ftl");
		Writer out = new OutputStreamWriter(os);

		ThriftServiceBuilder serviceBuilder = new ThriftServiceBuilder(commonServiceClass);
		ThriftService service = serviceBuilder.buildThriftService();

		Map<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put("thriftServicePackage", this.getPackageName(commonServiceClass));
		List<ThriftStruct> structs = serviceBuilder.getStructs();
		List<ThriftEnum> enums = serviceBuilder.getEnums();
		CommonUtils.removeRepeat(structs);
		rootMap.put("structList", structs);
		rootMap.put("enumList", enums);
		CommonUtils.removeRepeat(enums);
		rootMap.put("serviceList", Arrays.asList(service));

		template.process(rootMap, out);
	}

}
