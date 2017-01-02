package com.gescc.hedwig.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gescc.hedwig.service.MessageService;
import com.gescc.hedwig.vo.Message;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	private static Logger LOG = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private MessageService service;
	
	private ObjectMapper mapper = new ObjectMapper();
	private String jsonString;
	
	@ResponseBody
	@RequestMapping(value = "/messages")
	public String getAllMessageList(HttpServletRequest req, HttpServletResponse res) {
		//return service.getMessageListAll();
		LOG.error(service.getMessageListAll().toString());
		try {
			jsonString=mapper.writeValueAsString(service.getMessageListAll());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
		
	}

	
}
