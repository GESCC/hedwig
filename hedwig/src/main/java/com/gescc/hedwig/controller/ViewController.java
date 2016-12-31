package com.gescc.hedwig.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {
	
	@RequestMapping("/login")
	public String index(HttpServletRequest req, HttpServletResponse res){
		if(req.getSession().getAttribute("email") != null)
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
