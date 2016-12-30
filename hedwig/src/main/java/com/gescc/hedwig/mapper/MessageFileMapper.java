package com.gescc.hedwig.mapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gescc.hedwig.dao.MessageDao;
import com.gescc.hedwig.vo.Message;

@Repository
public class MessageFileMapper implements MessageDao{

	private volatile List<Message> messageList = new ArrayList<Message>();
	private volatile ObjectMapper mapper = new ObjectMapper();
	private URL url = MessageFileMapper.class.getResource("/data/message.json");
	private Logger LOG = LoggerFactory.getLogger(MessageFileMapper.class);
	
	@Override
	public List<Message> getMessageListByDate(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		List<Message> messageDateList = new ArrayList<>();
		for (Message msg : messageList) {
			if(msg.getSendDate().after(startDate) && msg.getSendDate().before(endDate)){
				messageDateList.add(msg);
			}
		}
		return messageDateList;
	}

	@Override
	public List<Message> getMessageListByApplicationName(String applicationName) {
		// TODO Auto-generated method stub
		List<Message> messageNameList = new ArrayList<>();
		for (Message msg : messageList) {
			if(msg.getSendApplicationName().equals(applicationName)){
				messageNameList.add(msg);
			}
		}
		return messageNameList;
	}

	@Override
	public List<Message> getMessageListAll() {
		// TODO Auto-generated method stub
		return messageList;
	}

	@Override
	public Boolean saveMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			messageList.add(message);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			this.saveFile();
		}
		catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Boolean deleteLastMessage() {
		// TODO Auto-generated method stub
		try {
			messageList.remove(messageList.size() - 1);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
//		try {
//			this.saveFile();
//		}
//		catch (JsonGenerationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return true;
	}
	
	public void saveFile() throws JsonGenerationException, JsonMappingException, IOException {
		LOG.error("들어오긴하니?");
		File file = new File(url.toString());
		PrintWriter out = new PrintWriter(new FileWriter(file, false));
		mapper.writeValue(out, messageList);
	}
}
