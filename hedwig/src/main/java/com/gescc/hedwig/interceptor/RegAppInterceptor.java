package com.gescc.hedwig.interceptor;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.crsh.console.jline.internal.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegAppInterceptor implements Filter {

	private Logger LOG = LoggerFactory.getLogger(RegAppInterceptor.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		LOG.info("intercept on");
		LOG.info(req.getRemoteAddr());
		LOG.info(req.getRemoteHost());
		
		chain.doFilter(req, res); 
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
