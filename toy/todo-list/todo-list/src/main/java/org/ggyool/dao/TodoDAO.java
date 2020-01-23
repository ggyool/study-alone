package org.ggyool.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ggyool.dto.TodoDTO;

public class TodoDAO {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String dbUrl = "jdbc:mysql://localhost:3306/connectdb?useSSL=true&verifyServerCertificate=false";
	private static String dbUser = "connectuser";
	private static String dbPassword = "connect123!@#";
	
	public int addTodo(TodoDTO dto) {
		int insertCount = 0;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		String sql = "INSERT INTO todo(title, name, sequence) VALUES(?, ?, ?)";
		try(Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getSequence());
			insertCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertCount;
	}
	
	public List<ArrayList<TodoDTO>>getList(){
		List<ArrayList<TodoDTO>> list = new ArrayList<ArrayList<TodoDTO>>();
		list.add(new ArrayList<TodoDTO>());
		list.add(new ArrayList<TodoDTO>());
		list.add(new ArrayList<TodoDTO>());
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		
		String sql = "SELECT id, title, name, sequence, type, regdate FROM todo ORDER BY regdate";
		try(Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
				PreparedStatement ps = conn.prepareStatement(sql)){
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					TodoDTO dto = new TodoDTO();
					String type = rs.getString(5);
					String strRegdate = rs.getString(6);
					String[] listRegdate = strRegdate.split(" ");
					dto.setId(rs.getLong(1));
					dto.setTitle(rs.getString(2));
					dto.setName(rs.getString(3));
					dto.setSequence(rs.getInt(4));
					dto.setType(type);
					dto.setRegdate(listRegdate[0]);
					if(type.contentEquals("TODO")) list.get(0).add(dto);
					else if(type.contentEquals("DOING")) list.get(1).add(dto);
					else if(type.contentEquals("DONE")) list.get(2).add(dto);
					else list.get(0).add(dto);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int updataTodo(TodoDTO dto) {
		int updateCount = 0;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		
		String sql = "UPDATE todo SET type=? WHERE id=?";
		try(Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
				PreparedStatement ps = conn.prepareStatement(sql)){
			if(dto.getType().contentEquals("TODO")) ps.setString(1, "DOING");
			else if(dto.getType().contentEquals("DOING")) ps.setString(1, "DONE");
			else ps.setString(1,  dto.getType());
			ps.setLong(2, dto.getId());
			updateCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateCount;
	}
	
	public int deleteTodo(TodoDTO dto) {
		int deleteCount = 0;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		
		String sql = "DELETE from todo WHERE id = ?";
		try(Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
				PreparedStatement ps = conn.prepareStatement(sql)){
			if(dto.getType().contentEquals("DONE")) {
				ps.setLong(1, dto.getId());
				deleteCount = ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteCount;
	}
}
