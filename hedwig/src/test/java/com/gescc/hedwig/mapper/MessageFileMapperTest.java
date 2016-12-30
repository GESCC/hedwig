package com.gescc.hedwig.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gescc.hedwig.dao.MessageDao;
import com.gescc.hedwig.vo.Message;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
@SpringBootTest
public class MessageFileMapperTest {

	private static Logger LOG = LoggerFactory.getLogger(MessageFileMapperTest.class);
	private final static String SEND_APPLICATOIN_NAME = "pandora";
	private final static String TITLE = "테스트 문자 발";
	private final static String CONTENTS = "테스트 문자 발송입니다 꺄르르르";
	private final static String RECEIVER_NUMBER = "01012345678";
	private final static Date SEND_DATE = new Date(2016, 12, 25);
	private final static Date BEFORE_DATE = new Date(2016,12,24);
	private final static Date AFTER_DATE = new Date(2016,12,26);
	private final static String RESULT = "success";
	
	@Autowired
	private MessageDao dao;
	
	@Test
	public void insertAndGetMessageList() {
		
		Message msg = new Message();
		msg.setContents(CONTENTS);
		msg.setReceiverNumber(RECEIVER_NUMBER);
		msg.setResult(RESULT);
		msg.setSendApplicationName(SEND_APPLICATOIN_NAME);
		msg.setSendDate(SEND_DATE);
		msg.setTitle(TITLE);
		
		int count = dao.getMessageListAll().size();
		
		assertThat(dao.saveMessage(msg), is(true));
		assertThat(dao.getMessageListByDate(BEFORE_DATE, AFTER_DATE).size(), is(1));
		assertThat(dao.getMessageListByApplicationName(SEND_APPLICATOIN_NAME).size(), is(1));
		assertThat(dao.getMessageListAll().size(), is(count + 1));
		dao.deleteLastMessage();
		
	}
}
