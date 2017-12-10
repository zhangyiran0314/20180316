package com.iflytransporter.api.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi(){
		ParameterBuilder tokenPar = new ParameterBuilder();
    	List<Parameter> pars = new ArrayList<Parameter>();
    	tokenPar.name("Authorization").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
    	pars.add((Parameter) tokenPar.build());
		return  new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
//				 .apis(RequestHandlerSelectors.basePackage("com.ifly.transporter.api.controller"))
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				 .paths(PathSelectors.any())
				 .build()
				 .globalOperationParameters(pars)
				 ;
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring Boot Swagger2构建 APIs")
				.description("api接口说明文档")
				.termsOfServiceUrl("NO terms of service")
				.contact(new Contact("张冠","252543781", "252543781@qq.com"))
				.version("1.0")
				.build();
	}
}
