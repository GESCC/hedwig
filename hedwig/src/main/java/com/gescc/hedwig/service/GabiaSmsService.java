package com.gescc.hedwig.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gabia.api.ApiClass;
import com.gescc.hedwig.util.KeyUtil;
import com.gescc.hedwig.vo.Sms;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class GabiaSmsService implements SmsService {

	private Logger LOG = LoggerFactory.getLogger(GabiaSmsService.class);
	@Value("${api.key}")
	private String API_KEY;
	@Value("${api.id}")
	private String API_ID;
	@Value("${api.sendNumber}")
	private String SEND_NUMBER;
	
	@Autowired
	private KeyUtil keyUtil;
	
	@Override
	public void sendSms(Sms sms) throws UnirestException {
		
		LOG.error(API_ID + API_KEY + SEND_NUMBER);
		// TODO Auto-generated method stub
		ApiClass api = new ApiClass(API_ID, API_KEY);
		//key 어떻게 만들지 생각해봐야함
		
		String arr[] = new String[7];
		arr[0] = "sms";	// SMS/LMS 발송 구분
		arr[1] = keyUtil.getSmsKey();	// 결과 확인을 위한 KEY (MAX 40byte. 중복되지 않도록 생성하여 전달해 주시기 바랍니다. )
		arr[2] = sms.getTitle();	// LMS 발송시 제목으로 사용 SMS 발송시는 수신자에게 내용이 보이지 않습니다.
		arr[3] = sms.getContents();	// 본문 (90byte 제한 : SMS의 경우)
		arr[4] = sms.getReceiverNumber();		// 발신 번호
		arr[5] = sms.getReceiverNumber();		// 수신 번호
		arr[6] = "0";		// 수신 번호
		String responseXml = api.send(arr);
		
		LOG.error(responseXml);
		this.sendCallBack(sms, responseXml);
	}

	@Override
	public void sendCallBack(Sms sms, Object result) throws UnirestException {
		// TODO Auto-generated method stub
		for(int count = 0; count < 10; count++){
			try {
				HttpResponse<JsonNode> jsonResponse = Unirest.post(sms.getCallbackUrl())
						  .header("accept", "application/json")
						  .field("result", result)
						  .asJson();
				break;
			}
			catch (UnirestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				if(count == 10){
					throw new UnirestException(e);
				}
				
				continue;
			}
		}
		
	}

}
