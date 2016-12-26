package com.gescc.hedwig.mapper;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gescc.hedwig.dao.AppDao;
import com.gescc.hedwig.vo.App;
import com.gescc.hedwig.vo.AppList;

@Repository
public class AppFileMapper implements AppDao {

	private ObjectMapper mapper = new ObjectMapper();

	private URL url = AppFileMapper.class.getResource("/data/app.json");
	private Logger LOG = LoggerFactory.getLogger(AppFileMapper.class);

	@Override
	public Boolean insertApp(App app) throws Throwable {
		// TODO Auto-generated method stub
		LOG.error(url.toString());
		AppList.getInstance().getMap().put(app.getAppName(), app);
		File file = new File(url.toURI());
		//수없이 쓸거아니니까 읽었다가 다시쓰자 그게 더 빠를것같다 	
		PrintWriter out = new PrintWriter(new FileWriter(file, false));
		mapper.writeValue(out, AppList.getInstance().getMap());
		return true;
	}

	@Override
	public Boolean deleteApp(String appName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public App selectApp(String appName) {
		// TODO Auto-generated method stub
		App app = (App) AppList.getInstance().getMap().get(appName);
		return app;
	}

	@Override
	public List<App> selectAllApp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean hasApp(String appIp) {
		// TODO Auto-generated method stub
		boolean hasApp = false;
		Iterator<Entry<String, App>> it = AppList.getInstance().getMap().entrySet().iterator();
		while(it.hasNext()){
			App app = it.next().getValue();
			if(appIp.equals(app.getIp())){
				hasApp = true;
			} else {
				hasApp = false;
			}
		}
		return hasApp;
	}

}