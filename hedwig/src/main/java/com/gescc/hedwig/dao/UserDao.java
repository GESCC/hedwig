package com.gescc.hedwig.dao;

import java.util.List;

import com.gescc.hedwig.vo.User;

/**
 * @author genie
 *
 */
public interface UserDao {

	public Boolean insertUser(User user) throws Throwable;
	public Boolean deleteUser(String userEmail);
	public User selectUser(String userEmail);
	public List<User> selectAllUser();
}
