package com.gescc.hedwig.mapper;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gescc.hedwig.dao.UserDao;
import com.gescc.hedwig.util.PasswordUtil;
import com.gescc.hedwig.vo.User;
import com.gescc.hedwig.vo.UserList;

/**
* UserFileMapper
* 
* @author geine
* @date 2016.12.22
* @version a
*/
@Repository
public class UserFileMapper implements UserDao {
	
	@Autowired
	private PasswordUtil passwordUtil;
	
	private ObjectMapper mapper = new ObjectMapper();
	//이부분 property로 제거 요망 - genie
	private URL url = UserFileMapper.class.getResource("/data/user.json");
	private Logger LOG = LoggerFactory.getLogger(UserFileMapper.class);
	
	@Override
	public Boolean insertUser(User user) throws Throwable {
		// TODO Auto-generated method stub
		LOG.error(url.toString());
		user.setPassword(passwordUtil.encodePassword(user.getPassword()));
		UserList.getInstance().getMap().put(user.getEmail(), user);
		File file = new File("../user.json");
		//수없이 쓸거아니니까 읽었다가 다시쓰자 그게 더 빠를것같다 	
		PrintWriter out = new PrintWriter(new FileWriter(file, false));
		mapper.writeValue(out, UserList.getInstance().getMap());
		return true;
	}

	@Override
	public Boolean deleteUser(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectUser(String userEmail) {
		// TODO Auto-generated method stub
		User user = (User) UserList.getInstance().getMap().get(userEmail);
		return user;
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return null;
	}
}
