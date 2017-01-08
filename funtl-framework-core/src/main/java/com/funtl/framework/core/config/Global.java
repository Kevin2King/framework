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

package com.funtl.framework.core.config;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.funtl.framework.core.utils.PropertiesLoader;
import com.funtl.framework.core.utils.StringUtils;
import com.google.common.collect.Maps;

import org.springframework.core.io.DefaultResourceLoader;

/**
 * 全局配置类.
 *
 * @author Lusifer Lee
 * @version 2017-01-08
 */
final public class Global {
	private Global() {
	}

	/**
	 * 当前对象实例.
	 */
	private static Global global = new Global();

	/**
	 * 保存全局属性值.
	 */
	private static Map<String, String> map = Maps.newHashMap();

	/**
	 * 属性文件加载对象.
	 */
	private static PropertiesLoader loader = new PropertiesLoader("funtl.properties");

	/**
	 * 显示.
	 */
	public static final String SHOW = "1";

	/**
	 * 隐藏.
	 */
	public static final String HIDE = "0";

	/**
	 * 是.
	 */
	public static final String YES = "1";

	/**
	 * 否.
	 */
	public static final String NO = "0";

	/**
	 * 对.
	 */
	public static final String TRUE = "true";

	/**
	 * 错.
	 */
	public static final String FALSE = "false";

	/**
	 * 获取当前对象实例.
	 *
	 * @return 全局对象
	 */
	public static Global getInstance() {
		return global;
	}

	/**
	 * 获取配置.
	 *
	 * @param key properties中的键
	 * @return properties中的值
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null) {
			value = loader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}

	/**
	 * 获取管理端根路径.
	 *
	 * @return properties中adminPath的值
	 */
	public static String getAdminPath() {
		return getConfig("adminPath");
	}

	/**
	 * 获取URL后缀.
	 *
	 * @return properties中的urlSuffix的值
	 */
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}

	/**
	 * 是否是演示模式，演示模式下不能修改用户、角色、密码、菜单、授权.
	 *
	 * @return properties中的demoMode的值
	 */
	public static Boolean isDemoMode() {
		String dm = getConfig("demoMode");
		return "true".equals(dm) || "1".equals(dm);
	}

	/**
	 * 在修改系统用户和角色时是否同步到Activiti.
	 *
	 * @return properties中的activiti.isSynActivitiIndetity的值
	 */
	public static Boolean isSynActivitiIndetity() {
		String dm = getConfig("activiti.isSynActivitiIndetity");
		return "true".equals(dm) || "1".equals(dm);
	}

	/**
	 * 页面获取常量.
	 *
	 * @param field 常量的字段名称
	 * @return 常量
	 */
	public static Object getConst(String field) {
		try {
			return Global.class.getField(field).get(null);
		} catch (Exception e) {
			// 异常代表无配置，这里什么也不做
		}
		return null;
	}

	/**
	 * 获取工程路径.
	 *
	 * @return 工程路径
	 */
	public static String getProjectPath() {
		// 如果配置了工程路径，则直接返回，否则自动获取。
		String projectPath = Global.getConfig("projectPath");
		if (StringUtils.isNotBlank(projectPath)) {
			return projectPath;
		}
		try {
			File file = new DefaultResourceLoader().getResource("").getFile();
			if (file != null) {
				while (true) {
					File f = new File(file.getPath() + File.separator + "src" + File.separator + "main");
					if (f == null || f.exists()) {
						break;
					}
					if (file.getParentFile() != null) {
						file = file.getParentFile();
					} else {
						break;
					}
				}
				projectPath = file.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projectPath;
	}

	//# don't touch
	public static String shopIcon() {
		return "";
	}
}
