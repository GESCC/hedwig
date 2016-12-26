package com.gescc.hedwig.service;


import com.gescc.hedwig.vo.Sms;

public class SmsServiceImpl implements SmsService {
	
	@Override
	public void sendSMS(Sms sms) {
		System.out.println(sms.toString());
	}
	
}