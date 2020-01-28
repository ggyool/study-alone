package org.ggyool.daoexam.main;

import java.util.List;

import org.ggyool.daoexam.config.ApplicationConfig;
import org.ggyool.daoexam.dao.RoleDao;
import org.ggyool.daoexam.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SelectAllTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		RoleDao roleDao = ac.getBean(RoleDao.class);
		List<Role> list = roleDao.selectAll();
		
		for(Role role : list) {
			System.out.println(role);
		}
	}
}
