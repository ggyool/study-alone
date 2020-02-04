package org.ggyool.reservation.tests;

import java.util.HashMap;
import java.util.List;

import org.ggyool.reservation.config.ApplicationConfig;
import org.ggyool.reservation.dao.ProductDAO;
import org.ggyool.reservation.dto.ProductDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductDaoTest {

	
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ProductDAO dao = ac.getBean(ProductDAO.class);
		List<HashMap<String, Object>> map = dao.selectByCategoryId(null,0,10);
		
		for(HashMap<String, Object> key : map) {
			System.out.println(key);
		}
	}
}
