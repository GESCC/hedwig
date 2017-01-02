package com.gescc.hedwig.service;

import com.gescc.hedwig.vo.Sms;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @author genie
 *
 */
public interface SmsService {
	
	public void sendSms(Sms sms) throws UnirestException;
	
	public void sendCallBack(Sms sms, Object result) throws UnirestException;
}
