package com.gescc.hedwig.interceptor;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gescc.hedwig.mapper.AppFileMapper;

public class RegAppInterceptor implements Filter {

	private Logger LOG = LoggerFactory.getLogger(RegAppInterceptor.class);
	@Resource(name = "appFileMapper")
	private AppFileMapper appFileMapper = new AppFileMapper();

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}


	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String ip = req.getRemoteAddr();
		try{
			if(appFileMapper.hasApp(ip)){
				LOG.error("Same IP is exist");
			}
			else
				chain.doFilter(req, res);
		}catch(Exception e){
			e.printStackTrace();
		} 
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
