package org.ggyool.jdbcexam;

import org.ggyool.jdbcexam.dao.RoleDao;
import org.ggyool.jdbcexam.dto.Role;

public class JDBCExam2 {
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		int res = dao.addRole(new Role(500, "CTO"));
		System.out.println(res);
	}
}
