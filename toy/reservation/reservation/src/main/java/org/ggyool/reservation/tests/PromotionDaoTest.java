package org.ggyool.reservation.tests;

import java.util.List;
import java.util.Map;

import org.ggyool.reservation.config.ApplicationConfig;
import org.ggyool.reservation.dao.PromotionDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PromotionDaoTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		PromotionDAO dao = ac.getBean(PromotionDAO.class);
		List<Map<String, Object>> map = dao.selectOnPromotion();
		
		for(Map<String, Object> key : map) {
			System.out.println(key);
		}
	}
}	
