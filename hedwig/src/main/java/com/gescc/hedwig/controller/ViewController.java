package com.gescc.hedwig.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

@Controller
@RequestMapping("/view")
public class ViewController {
	
	@Autowired
	private HttpServletRequest req;
	
	@RequestMapping("/login")
	public String index(){
		if(WebUtils.getSessionAttribute(req,"email") != null)
			return "/home/afterlogin";
		else
			return "/home/home";
	}

	@RequestMapping("/signup")
	public String signup(){
		return "/signup/signup";
	}
	
	@RequestMapping("/regapp")
	public String regapp(){
		return "/regapp/regapp";
	}

}
