/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.iflytransporter.api.conf;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.iflytransporter.api.conf.version.CustomRequestMappingHandlerMapping;

@Configuration
//public class WebMvcConfig extends WebMvcConfigurationSupport WebMvcConfigurerAdapter {
public class WebMvcConfig extends WebMvcConfigurationSupport{
	
	
    @Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        handlerMapping.setInterceptors(getInterceptors());
        return handlerMapping;
    }

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        
        //继承WebMvcConfigurationSupport时,swagger-ui需要添加一下配置
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		 
    }

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
	    converters.add(fastJsonHttpMessageConverters());
	    converters.add(responseBodyConverter());
	}
	
	@Bean
	public FastJsonHttpMessageConverter fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		List<MediaType> fastMediaTypes = new ArrayList<>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		converter.setSupportedMediaTypes(fastMediaTypes);
	    FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
            SerializerFeature.PrettyFormat,SerializerFeature.WriteDateUseDateFormat
        );
        converter.setFastJsonConfig(fastJsonConfig);
		return converter;
	}
	@Bean
	public HttpMessageConverter<?> responseBodyConverter() {
		 StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();  
	        stringHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(  
	                new MediaType("text", "plain", Charset.forName("utf-8")),  
	                new MediaType("text", "html", Charset.forName("utf-8")) ,
	                new MediaType("application", "octet-stream", Charset.forName("utf-8"))  
	        )); 
		return stringHttpMessageConverter;
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> excludesList = new ArrayList<String>();
		excludesList.add("/basic/**");//不需要token验证的基础包目录
		excludesList.add("/swagger*/**");
		excludesList.add("/v2/api-docs");
		excludesList.add("/*.html");
		/** for test */
		excludesList.add("/common/**");
		excludesList.add("/shipper/order/**");
		//excludesList.add("/user/**");
		/** for test */
		String[] excludes = new String[excludesList.size()];
		excludesList.toArray(excludes);
		registry.addInterceptor(new JwtInterceptor()).addPathPatterns("/**").excludePathPatterns(excludes);
	}
}
