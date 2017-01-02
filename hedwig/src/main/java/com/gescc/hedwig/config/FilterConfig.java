package com.gescc.hedwig.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gescc.hedwig.filter.AppFilter;

/**
 * @author heedong111
 *
 */
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