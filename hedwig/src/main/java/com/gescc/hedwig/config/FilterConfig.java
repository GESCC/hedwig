package com.gescc.hedwig.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gescc.hedwig.interceptor.RegAppInterceptor;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean getFilterRegistrationBean()
	{
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new RegAppInterceptor());
		return registrationBean;
	}
}
