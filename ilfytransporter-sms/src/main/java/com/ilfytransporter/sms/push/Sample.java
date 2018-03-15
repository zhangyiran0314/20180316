package com.ilfytransporter.sms.push;

import java.io.File;

import com.ilfytransporter.sms.push.configs.AndroidConfig;
import com.ilfytransporter.sms.push.configs.AndroidConfig.Priority;
import com.ilfytransporter.sms.push.notifications.AndroidNotification;


public class Sample {
	public static void main(String[] args) {
		// The folliwng three lines will be different for every implementation
		// 1. Client id, used to send messages to specific client
		// 2. Json file downloaded from the Firebase console, containing details for authentication to google
		// 3. Your project ID. Can also be found in the Firebase console.
		String CLIENT_ID = "cA7gOth0X1Q:APA91bERuP4lNAw_oOe9huC27Eao6TDFLEgBmDGnln0IpJDgXyBttxCMV6u1VtegzbfFAI4b3TwAWOceg2oB2A2UuVzpYcxyrZHEVuEiZBF3dSnsWnZds-pdwMxefQDojBj6JvIqQEyd";
		PushClient.setAccountFile(new File("service_account.json"));
		PushClient.setProjectId("fcmtest-f57d4");
		
		// Create Notification object
		Notification not = new Notification()
				.title("Hello World")
				.body("This is a notification");
		
		
		// Create OPTIONAL target configuration (in this case Android)
		AndroidConfig droidCfg = new AndroidConfig()
				.priority(Priority.HIGH)
				.notification(
						new AndroidNotification()
							.color("#ff0000")
						)
				.priority(Priority.HIGH);
			
		// Create Message and add Notification and Configurations to it
		Message raven = new Message()
				.name("id")
				.notification(not)
				.token(CLIENT_ID)
				.android(droidCfg);
		
		
		// Push the Message to FCM
		FcmResponse response = PushClient.push(raven);
		
		
		// Print API server response
		System.out.println(response);
	}
}
