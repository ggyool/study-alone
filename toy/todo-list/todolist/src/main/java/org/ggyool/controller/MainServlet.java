package org.ggyool.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ggyool.dao.TodoDao;
import org.ggyool.dto.TodoDto;


@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public MainServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");  
		response.setContentType("text/html;charset=utf-8");
		TodoDao dao = new TodoDao();
		List<ArrayList<TodoDto>> list = dao.getList();
		
		request.setAttribute("todoList", list.get(0));
		request.setAttribute("doingList", list.get(1));
		request.setAttribute("doneList", list.get(2));
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	} 

}
