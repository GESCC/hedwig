package com.gescc.hedwig.controller;

import static org.hamcrest.Matchers.hasKey;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
public class UserControllerTest {

	private final static String USER_EMAIL = "bonos2@wisdo.me";
	private final static String USER_PASSWORD = "testpassword";
	private final static String USER_PHONENUMBER = "01012345667";
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void insertUser() throws Exception {
		String json = "{" + 
						"\"email\" : \"" + USER_EMAIL + "\"," +
						"\"password\" : \"" + USER_PASSWORD + "\"," +
						"\"password\" : \"" + USER_PHONENUMBER + "\"" +
					  "}";
		
		this.mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(json))
		.andExpect(jsonPath("$", hasKey("code")))
		.andExpect(jsonPath("$.code").value("200"))
		.andReturn();
	}
	
}
