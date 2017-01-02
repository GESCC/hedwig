package com.gescc.hedwig.mapper;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gescc.hedwig.dao.MessageDao;
import com.gescc.hedwig.vo.Message;

/**
 * @author genie
 *
 */
@Repository
public class MessageFileMapper implements MessageDao{

	private ObjectMapper mapper = new ObjectMapper();
	private URL url = MessageFileMapper.class.getResource("/data/message.json");
	private Logger LOG = LoggerFactory.getLogger(MessageFileMapper.class);
	
	private volatile List<Message> messageList = new ArrayList<Message>();
	
	@PostConstruct
	public void initList(){
		
		try {
			File file = new File("./message.json");
			messageList = mapper.readValue(file, new TypeReference<List>() {
			});
			
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		
		LOG.info("Init Message List :" + messageList);
	}
	
	
	@Override
	public List<Message> getMessageListByDate(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		List<Message> messageDateList = new ArrayList<Message>();
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
		List<Message> messageNameList = new ArrayList<Message>();
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
		catch (Throwable e) {
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
	
	public void saveFile() throws Throwable {
		File file = new File("./message.json");
		LOG.error(file.getAbsolutePath());
		PrintWriter out = new PrintWriter(new FileWriter(file, false));
		mapper.writeValue(out, messageList);
	}
	
}
