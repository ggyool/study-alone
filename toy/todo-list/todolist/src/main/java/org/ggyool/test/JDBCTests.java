package org.ggyool.test;

import java.util.ArrayList;
import java.util.List;

import org.ggyool.dao.TodoDao;
import org.ggyool.dto.TodoDto;

public class JDBCTests {
	public static void main(String[] args) {
		TodoDao dao = new TodoDao();
		/*dao.addTodo(new TodoDto("하고있는중1", "ggyool", 2, "DOING"));
		dao.addTodo(new TodoDto("하고있는중2", "ggyool", 1, "DOING"));
		dao.addTodo(new TodoDto("하고있는중3", "ggyool", 2, "DOING"));
		dao.addTodo(new TodoDto("하고있는중4", "ggyool", 3, "DOING"));
		dao.addTodo(new TodoDto("끝남1", "ggyool", 1, "DONE"));
		dao.addTodo(new TodoDto("끝남2", "ggyool", 1, "DONE"));
		*/
		
		List<ArrayList<TodoDto>> list = dao.getList();
		for(List<TodoDto> lst : list) {
			for(TodoDto dto : lst) {
				System.out.println(dto);
			}
			System.out.println("-------------------");
		}
	}
}
