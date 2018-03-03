package com.iflytransporter.api.utils;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

public class MessageUtil {
	
	private static String sendApiKey="NUC13010100005665d5e24e1165d92b2f9f6001f68f092752";
	private static String sendUrl="http://cloudsms.trio-mobile.com/index.php/api/bulk_mt";
    private static String params = "api_key={apiKey}&action=send&to={to}&msg={msg}&sender_id=CLOUDSMS&content_type=1&mode=shortcode&campaign=";
	
	public static void sendMessage(String countryCode,String mobile,String msg){
		String param = params.replace("{apiKey}", sendApiKey);
		String to = countryCode+mobile;
		param = param.replace("{to}", to);
        // 最后生成一个HttpClient对象，并发出postMethod请求
        HttpClient httpClient = new HttpClient();
		try {
			param = param.replace("{msg}", URLEncoder.encode(msg,"utf-8"));
			String messageUrl = sendUrl+"?"+param;
			System.out.println(messageUrl);
			HttpMethod  getMethod = new GetMethod(messageUrl);  
			int statusCode = httpClient.executeMethod(getMethod);
			if(statusCode == 200) {
				System.out.println("短信发送成功!to="+to+",msg="+msg);
				System.out.println(getMethod.getResponseBodyAsString());  
	        }
		} catch (HttpException e) {
			System.out.println("短信发送失败!to="+to+",msg="+msg);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("短信发送失败!to="+to+",msg="+msg);
			e.printStackTrace();
		}
	}
	private static HttpMethod getMethod(String url,String param) throws IOException{
        GetMethod get = new GetMethod(url+"?"+param);
        get.releaseConnection();
        return get;
    }
	public static void main(String[] args){
		String countryCode ="+60";
		String mobile = "122330121";
		String msg ="Test Message from iflytransporter";
		sendMessage(countryCode, mobile, msg);
	}
}
