package com.gescc.hedwig.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import com.gescc.hedwig.vo.User;

/**
* UserServiceTest
* 
* @author geine
* @date 2016.12.22
* @version a
*/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class UserServiceTest {

	private final static String USER_EMAIL = "bonos2@wisdo.me";
	private final static String USER_PASSWORD = "testpassword";
	private final static String USER_PHONENUMBER = "01012345667";
	private final static String USER_INCORRECTPASSWORD = "test";
	
	private static Logger LOG = LoggerFactory.getLogger(UserServiceTest.class);
	
	@Autowired
	private UserService userService;
	
	@Test
	public void insertAndLoginUser() throws Exception {
		User user = new User();
		user.setEmail(USER_EMAIL);
		user.setPassword(USER_PASSWORD);;
		user.setPhoneNumber(USER_PHONENUMBER);
		
		User incorrectUser = new User();
		incorrectUser.setEmail(USER_EMAIL);
		incorrectUser.setPassword(USER_INCORRECTPASSWORD);
		incorrectUser.setPhoneNumber(USER_PHONENUMBER);
		
		assertThat(userService.createUser(user).getCode(), is("200"));
		assertThat(userService.doLogin(user).getCode(), is("200"));
		assertThat(userService.doLogin(incorrectUser).getCode(), is("501"));
		assertThat(userService.deleteUser(user.getEmail()).getCode(), is("200"));
		assertThat(userService.doLogin(user).getCode(), is("501"));
		
	}

}
