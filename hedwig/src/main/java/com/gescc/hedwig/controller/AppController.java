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

import com.gescc.hedwig.service.AppService;
import com.gescc.hedwig.view.ResultView;
import com.gescc.hedwig.vo.App;

/**
 * @author heedong111
 *
 */
@Controller
@RequestMapping("/applications")
public class AppController{
	private Logger LOG = LoggerFactory.getLogger(AppController.class);
	
	@Autowired
	private AppService appService;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResultView createApp(HttpServletRequest req, HttpServletResponse res, @RequestBody App app) throws Exception{
		
		LOG.info("craete app : " + app.toString());
		try {
			return appService.createApp(app);
		} catch (Exception e) {
			throw e;
		}
	}
}