package com.iflytransporter.api.conf;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * 国际化
 * @author zhangguan
 * zh-cn, zh, en-us, en
 * en-us, en
 */
@Component
public class LocaleMessageSourceConfig {
	
	public static String Lang_China ="zh-cn";
	public static String Lang_English ="en";
	public static String Lang_Maya="maya";
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
	
}
