package org.ggyool.daoexam.main;

import org.ggyool.daoexam.config.ApplicationConfig;
import org.ggyool.daoexam.dao.RoleDao;
import org.ggyool.daoexam.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JDBCTests {
	
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDao roleDao = ac.getBean(RoleDao.class);
		Role role = new Role();
		role.setroleId(501);
		role.setDescription("CE5");
		//int count = roleDao.insert(role);
		//int count = roleDao.update(role);
		//int count = roleDao.deleteById(501);
		//System.out.println(count + "실행");
		role = roleDao.selectById(500);
		System.out.println(role);
	}
}
