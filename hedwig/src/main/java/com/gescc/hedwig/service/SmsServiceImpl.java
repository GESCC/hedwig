package com.gescc.hedwig.service;


import com.gescc.hedwig.vo.Sms;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SmsServiceImpl implements SmsService {
	
	@Override
	public void sendSMS(Sms sms) {
		System.out.println(sms.toString());
	}

	@Override
	public void sendCallBack(Sms sms, Object result) throws UnirestException {
		// TODO Auto-generated method stub
		
	}
	
}