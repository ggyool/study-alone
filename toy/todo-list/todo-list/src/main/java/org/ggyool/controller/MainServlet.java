package org.ggyool.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ggyool.dao.TodoDAO;
import org.ggyool.dto.TodoDTO;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TodoDAO dao = new TodoDAO(); 
    
    public MainServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		List<ArrayList<TodoDTO>> list = dao.getList();
		
		// list 를 JSON string 으로 바꿔서 보낸다.
		ObjectMapper objectMapper = new ObjectMapper();
		request.setAttribute("todoList", objectMapper.writeValueAsString(list.get(0)));
		request.setAttribute("doingList", objectMapper.writeValueAsString(list.get(1)));
		request.setAttribute("doneList", objectMapper.writeValueAsString(list.get(2)));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");  
		response.setContentType("text/plain");
		;
		TodoDTO dto = new TodoDTO();
		Long id = Long.parseLong(request.getParameter("id"));
		String type = request.getParameter("type");
		dto.setId(id);
		dto.setType(type);
		int res;
		if(type.contentEquals("DONE"))
			res = dao.deleteTodo(dto);
		else
			res = dao.updataTodo(dto);
		PrintWriter out = response.getWriter();
		out.print(res==1?"success":"fail");
		out.close();
	}
}


