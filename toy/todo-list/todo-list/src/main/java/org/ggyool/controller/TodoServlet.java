package org.ggyool.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ggyool.dao.TodoDAO;
import org.ggyool.dto.TodoDTO;

@WebServlet("/todo")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TodoDAO dao = new TodoDAO();
    
    public TodoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");  
		response.setContentType("text/html;charset=utf-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("todo.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));
		TodoDTO dto = new TodoDTO(title, name, sequence);
		dao.addTodo(dto);
		
		response.sendRedirect("/main");
	}

}
