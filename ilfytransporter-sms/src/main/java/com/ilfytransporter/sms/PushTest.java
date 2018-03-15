package com.ilfytransporter.sms;

import java.io.File;

import com.ilfytransporter.sms.push.FcmResponse;
import com.ilfytransporter.sms.push.Message;
import com.ilfytransporter.sms.push.Notification;
import com.ilfytransporter.sms.push.PushClient;
import com.ilfytransporter.sms.push.configs.AndroidConfig;
import com.ilfytransporter.sms.push.configs.AndroidConfig.Priority;
import com.ilfytransporter.sms.push.notifications.AndroidNotification;

public class PushTest {
	public static String CLIENT_ID ="clientId";
	public static void main(String[]  args){
		//1.set your Project ID and your Service Account
		PushClient.setAccountFile(new File("service_account.json"));
		PushClient.setProjectId("project-1234");
		
		//2.create Notification
		Notification not = new Notification()
		.title("Hello World")
		.body("This is a notification");
		
		//3.(Optional) Create target specific configurations.
		AndroidConfig droidCfg = new AndroidConfig()
		.notification(
			new AndroidNotification()
			.color("#ff0000")
		)
		.priority(Priority.HIGH);
		
		//4.Create the Message (using Notification and any configs)
		Message msg = new Message()
	    .name("id")
		.notification(not)
		.token(CLIENT_ID) // could instead use: topic(String) or condition(String)
		.android(droidCfg);
		
		//5. Send the message
		PushClient.push(msg);
		 // or (if you want to access the response)
		FcmResponse response = PushClient.push(msg);
	}
}
