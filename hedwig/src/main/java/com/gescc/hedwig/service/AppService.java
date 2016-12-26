package com.gescc.hedwig.service;

import com.gescc.hedwig.view.ResultView;
import com.gescc.hedwig.vo.App;

public interface AppService {

	public ResultView createApp(App app) throws Exception;
	public ResultView deleteApp(String app);
	public ResultView updateApp(App app);
	
}
