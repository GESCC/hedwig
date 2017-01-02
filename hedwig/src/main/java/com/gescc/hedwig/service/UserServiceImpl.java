package com.gescc.hedwig.service;

import javax.naming.spi.DirStateFactory.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gescc.hedwig.dao.UserDao;
import com.gescc.hedwig.view.ResultView;
import com.gescc.hedwig.vo.User;
import com.gescc.hedwig.util.PasswordUtil;

/**
* UserService
* 
* @author geine
* @date 2016.12.22
* @version a
*/
@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao dao;
	
	@Autowired
	private PasswordUtil passwordUtil;
	
	@Override
	public ResultView createUser(User user) {
		// TODO Auto-generated method stub
		try{
			if(dao.insertUser(user)) {
				
				return new ResultView("200", "Success");
			} else {
				return new ResultView("500", "Internal Server Error");
			}
		} catch (Throwable e) {
			try {
				e.printStackTrace();
				return new ResultView("500", "Internal Server Error");
			}
			catch (Throwable e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResultView("500", "Internal Server Error");
			}
		}
	}

	@Override
	public ResultView deleteUser(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultView doLogin(User user) {
		// TODO Auto-generated method stub
		try{
			User saveUser = dao.selectUser(user.getEmail());
			
			if (saveUser.getPassword().equals(passwordUtil.encodePassword(user.getPassword()))){
				return new ResultView("200", "success");
			} else {
				return new ResultView("501", "password incorrect");
			}
		}catch(Exception e){
			return new ResultView("501", "password incorrect");
		}
	}

	@Override
	public ResultView updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
