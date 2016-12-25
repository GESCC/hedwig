package com.gescc.hedwig.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gescc.hedwig.vo.Sms;


public interface SmsService {
	
	public void sendSMS(Sms sms);
}
