package org.ggyool.reservation.tests;

import java.util.HashMap;
import java.util.List;

import org.ggyool.reservation.config.ApplicationConfig;
import org.ggyool.reservation.dao.CategoryDAO;
import org.ggyool.reservation.entity.CategoryEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryDaoTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		CategoryDAO dao = ac.getBean(CategoryDAO.class);
		CategoryEntity dto = new CategoryEntity();
		List<HashMap<String, Object>> list = dao.selectWithCount();
		for(HashMap<String, Object> val:list) {
			System.out.println(val);
		}
		System.out.println(dao.countProducts(1));
		System.out.println(dao.countProducts(null));

	}
}
