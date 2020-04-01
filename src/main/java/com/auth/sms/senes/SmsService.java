package com.auth.sms.senes;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	private final static String ACCOUNT_SID = "AC54c319c5db0a9e17cb96bee98dfb33c8";
	private final static String AUTH_ID = "224e7f0c6e95a89d5261cb6cf6f4d768";
	
	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}
	
	public boolean send2FaCode(String mobilenumber, String twoFaCode) {
	
		Message.creator(new PhoneNumber(mobilenumber), 
				new PhoneNumber("+5511960155898"), 
				"Codigo : " + twoFaCode).create();
		
		return true;
	}
}
