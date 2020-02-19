package org.ggyool.reservation.tests;

import org.ggyool.reservation.config.ApplicationConfig;
import org.ggyool.reservation.dao.DisplayInfoImageDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DisplayInfoImageDaoTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DisplayInfoImageDAO dao = ac.getBean(DisplayInfoImageDAO.class);
		System.out.println(dao.selectById(1));
	}
}
