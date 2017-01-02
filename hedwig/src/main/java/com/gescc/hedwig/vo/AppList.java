package com.gescc.hedwig.vo;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author heedong111
 *
 */
public class AppList {

	private static AppList instance;
	private Map map = new HashMap<String, App>();
	private AppList(){
	};
	
	public Map getMap() {
		return map;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}
	
	public void setMap() throws Throwable{
		ObjectMapper mapper = new ObjectMapper();
		URL url = AppList.class.getResource("/data/app.json");
		File file = new File("./app.json");
		Map<String,App> list = mapper.readValue(file, new TypeReference<Map<String,App>>(){});
		this.map = list;
	}
	
	public static synchronized AppList getInstance(){
		if (instance == null) {
			instance = new AppList();
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