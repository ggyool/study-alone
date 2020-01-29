package org.ggyool.guestbook.dao;

import java.util.Date;

import org.ggyool.guestbook.config.ApplicationConfig;
import org.ggyool.guestbook.dto.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LogDaoTest {
	public static void insertTest(LogDao dao) {
		Log log = new Log();
		log.setIp("127.0.0.1");
		log.setMethod("insert");
		log.setRegdate(new Date());
		Long id = dao.insert(log);
		System.out.println("insert= id:" + id);
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		LogDao dao = ac.getBean(LogDao.class);
		insertTest(dao);
	}
}
