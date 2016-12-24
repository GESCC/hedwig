package com.gescc.hedwig.vo;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gescc.hedwig.mapper.UserFileMapper;

public class UserList {

	private static UserList instance;
	private Map map = new HashMap<>();
	private UserList(){
	};
	
	public Map getMap() {
		return map;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}
	
	public void setMap() throws Throwable{
		ObjectMapper mapper = new ObjectMapper();
		URL url = UserList.class.getResource("/data/user.json");
		File file = new File(url.toURI());
		Map<String,User> list = mapper.readValue(file, new TypeReference<Map<String,User>>(){});
		this.map = list;
	}
	
	public static synchronized UserList getInstance(){
		if (instance == null) {
			instance = new UserList();
			try {
				instance.setMap();
			}
			catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				instance.setMap(new HashMap());
			}
		}
		return instance;
	}

	
}
