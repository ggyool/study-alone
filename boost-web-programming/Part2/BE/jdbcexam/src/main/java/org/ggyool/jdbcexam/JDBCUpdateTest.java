package org.ggyool.jdbcexam;

import org.ggyool.jdbcexam.dao.RoleDao;
import org.ggyool.jdbcexam.dto.Role;

public class JDBCUpdateTest {
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		int res = dao.updateRole(new Role(100, "Programmer"));
		System.out.println(res);
	}
}
