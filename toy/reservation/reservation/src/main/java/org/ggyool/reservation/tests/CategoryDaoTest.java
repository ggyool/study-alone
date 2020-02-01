package org.ggyool.reservation.tests;

import java.util.List;

import org.ggyool.reservation.config.ApplicationConfig;
import org.ggyool.reservation.dao.CategoryDAO;
import org.ggyool.reservation.dto.CategoryDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryDaoTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		CategoryDAO dao = ac.getBean(CategoryDAO.class);
		//CategoryDTO dto = new CategoryDTO();
		//dto.setName("임시");
		//dao.insert(dto);
		List<CategoryDTO> list = dao.selectAll();
		for(CategoryDTO val:list) {
			System.out.println(val);
		}
	}
}
