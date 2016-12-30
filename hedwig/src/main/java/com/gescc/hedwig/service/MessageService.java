
package com.gescc.hedwig.service;

import java.util.Date;
import java.util.List;

import com.gescc.hedwig.vo.Message;

public interface MessageService {

	List<Message> getMessageListByDate(Date startDate, Date endDate);

	List<Message> getMessageListByApplicationName(String applicationName);

	List<Message> getMessageListAll();
}
