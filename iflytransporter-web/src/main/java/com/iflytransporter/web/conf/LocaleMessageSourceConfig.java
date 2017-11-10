package com.iflytransporter.web.conf;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * 国际化全�?���?
 * @author zhangguan
 * zh-cn, zh, en-us, en
 * en-us, en
 */
@Component
public class LocaleMessageSourceConfig {
	
	@Autowired
	private MessageSource messageSource;
	
	public String getMessage(String code){
       return getMessage(code,null);
    }
	public String getMessage(String code,Object[] args){
       return getMessage(code, args,"");
    }
	public String getMessage(String code,Object[] args,String defaultMessage){
       Locale locale = LocaleContextHolder.getLocale();
       return messageSource.getMessage(code, args, defaultMessage, locale);
    }
	/**
	 * 基于SessionLocaleResolver做session国际�?
	 * 设置不同的Locale定义当前的默认session国际化环�?
	 * 使用new Locale("en", "US"),new Locale("zh", "CN")配置才会生效
	 * 
	 * 基于SessionLocaleResolver的国际化配置是根据session可做修改�?�?��在controller中可定义当前session的国际化配置
	 * 查看SimpleMessageController changeSessionLocale(HttpServletRequest request)方法
	 */
	@Bean  
	public LocaleResolver sessionLocaleResolver() {  
	    SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();  
	    sessionLocaleResolver.setDefaultLocale(Locale.CHINA); //不生�?
//	    sessionLocaleResolver.setDefaultLocale(new Locale("en", "US"));
//	    sessionLocaleResolver.setDefaultLocale(new Locale("zh", "CN"));
	    return sessionLocaleResolver;  
	} 
	/**
	 * 基于CookieLocaleResolver做session国际�?
	 * 设置不同的Locale定义当前的默认session国际化环�?
	 * 使用new Locale("en", "US"),new Locale("zh", "CN")配置才会生效
	 */
/*	@Bean  
	public LocaleResolver cookieLocaleResolver() {  
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        //设置默认区域
//	    cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH); //不生�?
//		cookieLocaleResolver.setDefaultLocale(new Locale("en", "US"));
		cookieLocaleResolver.setDefaultLocale(new Locale("zh", "CN"));
		cookieLocaleResolver.setCookieMaxAge(3600);//设置cookie有效�?
	    return cookieLocaleResolver;  
	} */
}
