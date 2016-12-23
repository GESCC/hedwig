package com.gescc.hedwig.controller;

import static org.hamcrest.Matchers.hasKey;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class SmsControllerTest {

	
	private static final String TITLE = "테스트";

	private static final String APPLICATION_NAME = "pandora";

	private static final String RECEIVER_NUMBER = "01012345678";

	private static final String CONTENTS = "테스트 문자";

	private static final String CALLBACK_URL = "http://www.pandora.com/result";
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void insertSms() throws Exception {
		String json = "{" + 
						"\"title\" : \"" + TITLE + "\"," +
						"\"receiver_number\" : \"" + RECEIVER_NUMBER + "\"," +
						"\"application_name\" : \"" + APPLICATION_NAME + "\"," +
						"\"contents\" : \"" + CONTENTS + "\"," +
						"\"callback_url\" : \"" + CALLBACK_URL + "\"" +
					  "}";
		
		this.mockMvc.perform(post("/sms").contentType(MediaType.APPLICATION_JSON).content(json))
		.andExpect(jsonPath("$", hasKey("code")))
		.andExpect(jsonPath("$.code").value("200"))
		.andReturn();
	}
	
}

