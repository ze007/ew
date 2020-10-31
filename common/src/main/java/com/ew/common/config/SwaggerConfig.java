package com.ew.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "project.swagger-enabled", havingValue = "true", matchIfMissing = true)
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("默认接口")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ew"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder().title("Ew后台管理系统数据接口")
				.description("Swagger是一个规范和完整的框架，用于生成、描述、调用和可视化RESTful风格的Web服务。")
				.contact(new Contact("Mr`Huang","",""))
//				.termsOfServiceUrl("http://www.ew.com")
				.version("1.0-SNAPSHOT")
				.build();
	}
}
