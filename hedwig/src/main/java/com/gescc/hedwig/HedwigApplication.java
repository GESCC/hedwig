package com.gescc.hedwig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HedwigApplication {

	private static Logger LOG = LoggerFactory.getLogger(HedwigApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(HedwigApplication.class, args);
	}
}
