package com.gescc.hedwig.dao;

import java.util.List;

import com.gescc.hedwig.vo.App;

/**
 * @author heedong111
 *
 */
public interface AppDao {

	public Boolean insertApp(App app) throws Throwable;
	public Boolean deleteApp(String appName);
	public App selectApp(String appName);
	public List<App> selectAllApp();
	public Boolean hasApp(String appIp);
}
