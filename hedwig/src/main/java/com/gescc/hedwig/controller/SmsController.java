package com.gescc.hedwig.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gescc.hedwig.service.SmsService;
import com.gescc.hedwig.view.ResultView;
import com.gescc.hedwig.vo.Sms;

@Controller
@RequestMapping(value="/sms")
public class SmsController {

	private static Logger LOG = LoggerFactory.getLogger(SmsController.class);
	
	@Autowired
	private SmsService service;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public ResultView singleSMS(HttpServletRequest req, HttpServletResponse res, @RequestBody Sms sms ) throws Exception {
		LOG.info("Send SMS : " + sms.toString());
		try {
			service.sendSMS(sms);
		} catch(Exception e) {
			
			throw e;
		}
		
		return new ResultView("200", "OK");
	}
}