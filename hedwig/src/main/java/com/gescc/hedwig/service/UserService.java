package com.gescc.hedwig.service;

import com.gescc.hedwig.view.ResultView;
import com.gescc.hedwig.vo.User;

/**
* UserService Interface
* 
* @author geine
* @date 2016.12.22
* @version a
*/
public interface UserService {

	public ResultView createUser(User user) throws Exception;
	public ResultView deleteUser(String userEmail);
	public ResultView doLogin(User user);
	public ResultView updateUser(User user);
	
}
