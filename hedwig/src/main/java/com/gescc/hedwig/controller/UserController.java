package com.gescc.hedwig.controller;

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

import com.gescc.hedwig.dao.UserDao;
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
	private UserService userService;
	@Autowired
	private UserDao dao;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResultView createUser(HttpServletRequest req, HttpServletResponse res, @RequestBody User user) throws Exception{
		
		LOG.info("craete user : " + user.toString());
		try {
			return userService.createUser(user);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public ResultView doLogin(HttpServletRequest req, HttpServletResponse res, @RequestBody User user) throws Exception{
		LOG.info("login user : " + user.toString());
		try {
			if(req.getSession().getAttribute("email") == null && dao.selectUser(user.getEmail()) != null){
				req.getSession().setAttribute("email", user.getEmail());
				req.getSession().setAttribute("phoneNumber", user.getPhoneNumber());
			}
			return userService.doLogin(user);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String doLogout(HttpServletRequest req, HttpServletResponse res) throws Exception{
		LOG.info("logout");
		req.getSession().invalidate();
		return "redirect:/view/login";
	}
}
