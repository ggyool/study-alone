package org.ggyool.reservation.tests;

import org.ggyool.reservation.config.ApplicationConfig;
import org.ggyool.reservation.dao.ProductDAO;
import org.ggyool.reservation.entity.ProductEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductDaoTest {

	
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ProductDAO dao = ac.getBean(ProductDAO.class);
//		List<Map<String, Object>> map = dao.selectByCategoryId(null,0,10);
//		
//		for(Map<String, Object> key : map) {
//			System.out.println(key);
//		}
		ProductEntity entity = dao.select(1);
		System.out.println(entity);
	}
}
