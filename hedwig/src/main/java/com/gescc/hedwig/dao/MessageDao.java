package com.gescc.hedwig.dao;

import java.util.Date;
import java.util.List;

import com.gescc.hedwig.vo.Message;

/**
 * @author genie
 *
 */
public interface MessageDao {

	List<Message> getMessageListByDate(Date startDate, Date endDate);
	
	List<Message> getMessageListByApplicationName(String applicationName);
	
	List<Message> getMessageListAll();
	
	Boolean saveMessage(Message message);
	
	Boolean deleteLastMessage();
	
}
