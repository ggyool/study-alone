package org.ggyool.test;

import java.util.List;

import org.ggyool.dao.TodoDao;
import org.ggyool.dto.TodoDto;

public class JDBCTests {
	public static void main(String[] args) {
		TodoDao dao = new TodoDao();
		//dao.addTodo(new TodoDto("�ڹٽ�ũ��Ʈ �����ϱ�", "ggyool", 3));
		//dao.addTodo(new TodoDto("�������� �����ϱ�", "ggyool", 3));
		//dao.addTodo(new TodoDto("��Ա�", "ggyool", 1));
		//dao.addTodo(new TodoDto("������ �����ϱ�", "ggyool", 2));
		
		List<TodoDto> list = dao.getTodos();
		for(TodoDto dto : list) {
			System.out.println(dto);
		}
	}
}
