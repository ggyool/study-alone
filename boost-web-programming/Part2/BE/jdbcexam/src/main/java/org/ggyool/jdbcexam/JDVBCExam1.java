package org.ggyool.jdbcexam;

import org.ggyool.jdbcexam.dao.RoleDao;
import org.ggyool.jdbcexam.dto.Role;

public class JDVBCExam1 {
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);
	}
}
