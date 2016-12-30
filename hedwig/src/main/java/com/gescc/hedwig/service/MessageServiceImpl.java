package com.gescc.hedwig.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gescc.hedwig.dao.MessageDao;
import com.gescc.hedwig.vo.Message;

@Service
public class MessageServiceImpl implements MessageService {

	private static Logger LOG = LoggerFactory.getLogger(MessageServiceImpl.class);
	
	@Autowired
	private MessageDao dao;
	
	@Override
	public String getMessageListByDate(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessageListByApplicationName(String applicationName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessageListAll() {
		// TODO Auto-generated method stub
		return dao.getMessageListAll();
	}

}
