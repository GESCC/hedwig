package com.gescc.hedwig.dao;

import java.util.List;

import com.gescc.hedwig.vo.App;

public interface AppDao {

	public Boolean insertApp(App app) throws Throwable;
	public Boolean deleteApp(String appName);
	public App selectApp(String appName);
	public List<App> selectAllApp();
}
