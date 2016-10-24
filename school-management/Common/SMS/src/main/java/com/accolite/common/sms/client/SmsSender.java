package com.accolite.common.sms.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SmsSender implements SmsService {

	public String sendSms(String smsMessage, String phoneNumber) {
		// TODO Auto-generated method stub
		try {
			// Construct data
			// String user = "username=" + "zakir.prof@gmail.com";
			// String hash = "&hash=" +
			// "cdf053c2b8bf4eab97ed9cd35ef19c64592c82a6";

			String apiKey = "apiKey=" + "sc0h/7bpsDE-4BZtz7Z5YjOEqnFTlwqEpMKXOXij36";
			String message = "&message=" + smsMessage;
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + phoneNumber;

			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("http://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();

			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}
	}

}
