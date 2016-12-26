package com.gescc.hedwig.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gescc.hedwig.vo.Sms;
import com.mashape.unirest.http.exceptions.UnirestException;


public interface SmsService {
	
	public void sendSMS(Sms sms) throws UnirestException;
	
	public void sendCallBack(Sms sms, Object result) throws UnirestException;
}
