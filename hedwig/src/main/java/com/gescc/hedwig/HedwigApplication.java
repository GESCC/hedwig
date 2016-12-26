package com.gescc.hedwig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/smsconfig.properties")
public class HedwigApplication {

	private static Logger LOG = LoggerFactory.getLogger(HedwigApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(HedwigApplication.class, args);
	}
}
