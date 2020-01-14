package org.ggyool.test;

import java.util.List;

import org.ggyool.dao.TodoDao;
import org.ggyool.dto.TodoDto;

public class JDBCTests {
	public static void main(String[] args) {
		TodoDao dao = new TodoDao();
		//dao.addTodo(new TodoDto("자바스크립트 공부하기", "ggyool", 3));
		//dao.addTodo(new TodoDto("제이쿼리 공부하기", "ggyool", 3));
		//dao.addTodo(new TodoDto("밥먹기", "ggyool", 1));
		//dao.addTodo(new TodoDto("스프링 공부하기", "ggyool", 2));
		
		List<TodoDto> list = dao.getTodos();
		for(TodoDto dto : list) {
			System.out.println(dto);
		}
	}
}
