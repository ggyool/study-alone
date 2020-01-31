package org.ggyool.guestbook.tests;

import org.ggyool.guestbook.config.ApplicationConfig;
import org.ggyool.guestbook.dto.GuestBook;
import org.ggyool.guestbook.service.GuestBookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GuestBookServiceTest {


	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GuestBookService guestBookService = ac.getBean(GuestBookService.class);
		
		GuestBook guestBook = new GuestBook();
		guestBook.setName("파이리");
		guestBook.setContent("화염방사");
		//guestBook.setRegdate(new Date());
		GuestBook res = guestBookService.addGuestBook(guestBook, "127.0.0.1");
		System.out.println(res);
	}
}
