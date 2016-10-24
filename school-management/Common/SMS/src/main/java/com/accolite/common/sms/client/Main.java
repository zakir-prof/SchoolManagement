package com.accolite.common.sms.client;

public class Main {
	
	public static void main(String args[]) {
		SmsService service = new SmsSender();
		String status = service.sendSms("Hi Kartik! \n How r u?", "9122520895");
		System.out.println(status);
	}
}
