package com.iflytransporter.api.conf;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 常量配置application.yml文件 对应属解析
 * @author zhangguan
 */
@Component
public class ConstantsConfig {
	
	
	private static String filePath;
	private static String host;
	private  static String linkPath;
	private static boolean messageSendFlag;
	private static String messageApiKey;
	private static String messageSendUrl;
	/**
	 * 打印常量配置是否正确
	 */
	@PostConstruct
	public void PostConstruct(){
		System.out.println("####################application.yml config start####################");
		System.out.println("upload.filePath value:"+filePath);
		System.out.println("upload.host value:"+host);
		System.out.println("upload.linkPath value:"+linkPath);
		System.out.println("message.sendFlag value:"+messageSendFlag);
		System.out.println("message.sendUrl value:"+messageSendUrl);
		System.out.println("####################application.yml config end####################");
	}

	public String getHost() {
		return host;
	}
	@Value("${upload.host}")
	public void setHost(String host) {
		ConstantsConfig.host = host;
	}
	@Value("${upload.filePath}")
	public void setFilePath(String filePath) {
		ConstantsConfig.filePath = filePath;
	}
	@Value("${upload.linkPath}")
	public void setLinkPath(String linkPath) {
		ConstantsConfig.linkPath = linkPath;
	}
	public String getFilePath() {
		return filePath;
	}
	/**
	 * 特别注意此静态方法,
	 * 为通过配置文件读取文件linkPath目录,
	 * 直接在mybatis mapper查询中使用
	 * */
	public static String getLinkPath(){
		return host+linkPath;
	}
	/**message短信发送*/
	public static boolean isMessageSendFlag() {
		return messageSendFlag;
	}
	@Value("${message.sendFlag}")
	public  void setMessageSendFlag(boolean messageSendFlag) {
		ConstantsConfig.messageSendFlag = messageSendFlag;
	}
	public static String isMessageSendUrl() {
		return messageSendUrl;
	}
	@Value("${message.sendUrl}")
	public  void setMessageSendUrl(String messageSendUrl) {
		ConstantsConfig.messageSendUrl = messageSendUrl;
	}

	public static String getMessageApiKey() {
		return messageApiKey;
	}
	@Value("${message.sendApiKey}")
	public  void setMessageApiKey(String messageApiKey) {
		ConstantsConfig.messageApiKey = messageApiKey;
	}

	public static String getMessageSendUrl() {
		return messageSendUrl;
	}
	
}
