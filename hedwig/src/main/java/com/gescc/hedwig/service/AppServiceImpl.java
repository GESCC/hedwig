package com.gescc.hedwig.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gescc.hedwig.dao.AppDao;
import com.gescc.hedwig.view.ResultView;
import com.gescc.hedwig.vo.App;

@Service("appService")
public class AppServiceImpl implements AppService{

	private static Logger LOG = LoggerFactory.getLogger(AppServiceImpl.class);

	@Autowired
	private AppDao dao;

	@Override
	public ResultView createApp(App app) throws Exception {
		// TODO Auto-generated method stub
		try{
			if(dao.insertApp(app)) {

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
	public ResultView deleteApp(String app) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultView updateApp(App app) {
		// TODO Auto-generated method stub
		return null;
	}

}