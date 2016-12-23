package com.gescc.hedwig.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gescc.hedwig.service.UserService;
import com.gescc.hedwig.view.ResultView;
import com.gescc.hedwig.vo.User;

/**
* UserController
* 
* @author geine
* @date 2016.12.22
* @version a
*/

@Controller
@RequestMapping("/users")
public class UserController {

	private Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ResultView createUser(HttpServletRequest req, HttpServletResponse res, @RequestBody User user){
		
		LOG.info("craete user : " + user.toString());
		try {
			service.createUser(user);
		} catch (Exception e) {
			throw e;
		}
		

		return new ResultView("200", "Success");
	}
}
