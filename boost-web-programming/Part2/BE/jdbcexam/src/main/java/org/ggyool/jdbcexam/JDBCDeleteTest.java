package org.ggyool.jdbcexam;

import org.ggyool.jdbcexam.dao.RoleDao;

public class JDBCDeleteTest {
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		System.out.println(dao.deleteRole(500));
	}
}
