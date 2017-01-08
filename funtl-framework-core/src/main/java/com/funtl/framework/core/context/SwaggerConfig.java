package com.funtl.framework.core.context;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 李卫民 on 2016/7/26.
 */
@Configuration
@EnableSwagger
public class SwaggerConfig {
	private SpringSwaggerConfig springSwaggerConfig;

	/**
	 * Required to autowire SpringSwaggerConfig
	 */
	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	/**
	 * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
	 * framework - allowing for multiple swagger groups i.e. same code base
	 * multiple swagger resource listings.
	 */
	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(".*api.*?");
	}

	private ApiInfo apiInfo() {
		//        ApiInfo apiInfo = new ApiInfo(
		//                "My Apps API Title",
		//                "My Apps API Description",
		//                "My Apps API terms of service",
		//                "My Apps API Contact Email",
		//                "My Apps API Licence Type",
		//                "My Apps API License URL");
		ApiInfo apiInfo = new ApiInfo("项目API", "项目API测试工具", "无", "topsale@vip.qq.com", "无", "无");
		return apiInfo;
	}
}
