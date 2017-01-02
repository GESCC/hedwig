package com.gescc.hedwig.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author genie
 *
 */
@Controller
@RequestMapping("/view")
public class ViewController {
	
	@RequestMapping("/login")
	public String index(HttpServletRequest req, HttpServletResponse res){
		if(req.getSession().getAttribute("email") != null)
			return "/admin/admin";
		else
			return "/home/home";
	}
	
	@RequestMapping("/regapp")
	public String regapp(HttpServletRequest req, HttpServletResponse res){
		if(req.getSession().getAttribute("email") != null)
			return "/regapp/regapp";
		else
			return "/home/home";
	}
	
	@RequestMapping("/admin")
	public String admin(HttpServletRequest req, HttpServletResponse res){
		if(req.getSession().getAttribute("email") != null)
			return "/admin/admin";
		else
			return "/home/home";
	}

}
