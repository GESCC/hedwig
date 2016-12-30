package com.gescc.hedwig.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gescc.hedwig.filter.AppFilter;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean getFilterRegistrationBean()
	{
		
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new AppFilter());
		registrationBean.addUrlPatterns("/*");
		
		return registrationBean;
	}
}
