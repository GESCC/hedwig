package com.gescc.hedwig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {
	
	@RequestMapping("/login")
	public String index(){
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
