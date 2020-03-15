package org.ggyool.guestbook.tests;

import java.util.Date;

import org.ggyool.guestbook.config.ApplicationConfig;
import org.ggyool.guestbook.dao.GuestBookDao;
import org.ggyool.guestbook.dto.GuestBook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GuestBookDaoTest {
	
	public static void insertTest(GuestBookDao dao) {
		GuestBook guestBook = new GuestBook();
		guestBook.setName("피카츄");
		guestBook.setContent("십만볼트");
		guestBook.setRegdate(new Date());
		Long id = dao.insert(guestBook);
		System.out.println("insert= id:" + id);
	}
	
	public static void main(String[] args) {
		//ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//GuestBookDao dao = ac.getBean(GuestBookDao.class);
		//insertTest(dao);
	}
}
