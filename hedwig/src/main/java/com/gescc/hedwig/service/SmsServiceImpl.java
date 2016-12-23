package com.gescc.hedwig.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gescc.hedwig.vo.Sms;

@Configuration
public class SmsServiceImpl implements SmsService {
	
	@Override
	public void sendSMS(Sms sms) {
		System.out.println(sms.toString());
	}
	
}