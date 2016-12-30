
package com.gescc.hedwig.service;

import java.util.Date;
import java.util.List;

import com.gescc.hedwig.vo.Message;

public interface MessageService {

	String getMessageListByDate(Date startDate, Date endDate);

	String getMessageListByApplicationName(String applicationName);

	String getMessageListAll();
}
