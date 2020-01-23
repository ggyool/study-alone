package org.ggyool.test;

import java.util.ArrayList;
import java.util.List;

import org.ggyool.dao.TodoDAO;
import org.ggyool.dto.TodoDTO;

public class JDBCTests {
	public static void main(String[] args) {
		TodoDAO dao = new TodoDAO();
		/*dao.addTodo(new TodoDto("하고있는중1", "ggyool", 2, "DOING"));
		dao.addTodo(new TodoDto("하고있는중2", "ggyool", 1, "DOING"));
		dao.addTodo(new TodoDto("하고있는중3", "ggyool", 2, "DOING"));
		dao.addTodo(new TodoDto("하고있는중4", "ggyool", 3, "DOING"));
		dao.addTodo(new TodoDto("끝남1", "ggyool", 1, "DONE"));
		dao.addTodo(new TodoDto("끝남2", "ggyool", 1, "DONE"));
		*/
		//List<ArrayList<TodoDTO>> list =dao.getList();
		//System.out.println(list.get(0));
		//System.out.println(list.get(1));
		//System.out.println(list.get(2));

	}
}
