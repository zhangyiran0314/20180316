package com.iflytransporter.api.utils;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

public class MessgeUtil {
	
	private static String sendApiKey="NUC13010100005665d5e24e1165d92b2f9f6001f68f092752";
	private static String sendUrl="http://cloudsms.trio-mobile.com/index.php/api/bulk_mt?api_key={apiKey}&action=send&to={to}&msg={msg}&sender_id=CLOUDSMS&content_type=1&mode=shortcode&campaign=";
	
	public static void sendMessage(String countryCode,String mobile,String msg){
		PostMethod postMethod = new PostMethod(sendUrl);
        // 最后生成一个HttpClient对象，并发出postMethod请求
        HttpClient httpClient = new HttpClient();
        int statusCode;
		try {
			statusCode = httpClient.executeMethod(postMethod);
			if(statusCode == 200) {
				System.out.println("发送成功!");
	        }
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
