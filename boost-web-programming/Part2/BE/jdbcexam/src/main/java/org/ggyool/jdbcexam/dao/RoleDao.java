package org.ggyool.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ggyool.jdbcexam.dto.Role;

public class RoleDao {
	private static String dbUrl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbPassword = "connect123!@#";
	private static String driverName = "com.mysql.jdbc.Driver";
	
	
	public Role getRole(Integer roleID ) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			String sql = "SELECT role_id, description FROM role WHERE role_id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleID);
			rs = ps.executeQuery();
			if(rs.next()) {
				int id  = rs.getInt("role_id"); // 필드명을 적어도 되고
				String desc = rs.getString(2); // 위의 SELECT 문 순서를 적어도 된다
				role = new Role(id, desc);
			}
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if(rs!=null) 
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null) 
			{
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) 
			{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return role;
	}
	
	public int addRole(Role role) {
		int insertCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		// 결과값이 result set이 아니라 만들 필요 없다. 
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			String sql = "INSERT INTO role(role_id, description) VALUES (?,?)";
			ps = conn.prepareStatement(sql); 
			
			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());
			insertCount = ps.executeUpdate(); // select 일 때와 다름 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(ps!=null) 
			{
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) 
			{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return insertCount;
	}
	
	public int updateRole(Role role) {
		int updateCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			String sql = "UPDATE role SET description = ? where role_id = ?";
			ps = conn.prepareStatement(sql); 
			ps.setString(1, role.getDescription());
			ps.setInt(2, role.getRoleId());
			updateCount = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(ps!=null) 
			{
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) 
			{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return updateCount;
	}
	
	public int deleteRole(Integer roleID) {
		int deleteCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			String sql = "DELETE FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql); 
			ps.setInt(1, roleID);
			deleteCount = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(ps!=null) 
			{
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) 
			{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return deleteCount;
	}
	
	public List<Role> getRolesFirst(){
		List<Role> list = new ArrayList<>();
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			String sql = "SELECT role_id, description FROM role";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id  = rs.getInt("role_id"); // 필드명을 적어도 되고
				String desc = rs.getString(2); // 위의 SELECT 문 순서를 적어도 된다
				role = new Role(id, desc);
				list.add(role);
			}
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if(rs!=null) 
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null) 
			{
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) 
			{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	// getRolesFirst와의 차이
	// try with 구문을 써서 close 하지 않아도 된다.
	public List<Role> getRoles(){
		List<Role> list = new ArrayList<>();
		try {
			Class.forName(driverName);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		String sql = "SELECT description, role_id FROM role order by role_id desc";
		try(Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()){
					String desc = rs.getString(1);
					int id = rs.getInt(2);
					Role role = new Role(id, desc);
					list.add(role);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}








