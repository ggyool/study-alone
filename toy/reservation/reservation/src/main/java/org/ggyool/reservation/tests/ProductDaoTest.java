package org.ggyool.reservation.tests;

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
		List<ProductDTO> list = dao.selectByCategoryId(5L, 0L, 10L);
		
		for(ProductDTO dto : list) {
			System.out.println(dto);
		}
	}
}
