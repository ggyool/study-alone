package org.ggyool.reservation.tests;

import org.ggyool.reservation.config.ApplicationConfig;
import org.ggyool.reservation.dao.DisplayInfoDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DisplayInfoTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DisplayInfoDAO dao = ac.getBean(DisplayInfoDAO.class);
		System.out.println(dao.selectById(1));
	}
}
