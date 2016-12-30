package com.gescc.hedwig.dao;

import java.util.Date;
import java.util.List;

import com.gescc.hedwig.vo.Message;

/**
 * @author geine
 *
 */
public interface MessageDao {

	String getMessageListByDate(Date startDate, Date endDate);
	
	String getMessageListByApplicationName(String applicationName);
	
	String getMessageListAll();
	
	Boolean saveMessage(Message message);
	
	Boolean deleteLastMessage();
}
