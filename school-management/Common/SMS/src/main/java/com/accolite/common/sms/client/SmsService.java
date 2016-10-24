package com.accolite.common.sms.client;

public interface SmsService {
	//send sms to a particular mobile number
	public String sendSms(String smsMessage, String phoneNumber);

}
