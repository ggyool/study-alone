package org.ggyool.jdbcexam;

import java.util.List;

import org.ggyool.jdbcexam.dao.RoleDao;
import org.ggyool.jdbcexam.dto.Role;

public class JDBCGetListTest {
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		List<Role> list = dao.getRoles();
		
		for(Role role : list)
		{
			System.out.println(role);
		}
	}
}
