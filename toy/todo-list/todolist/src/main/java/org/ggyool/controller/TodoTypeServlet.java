package org.ggyool.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ggyool.dao.TodoDao;
import org.ggyool.dto.TodoDto;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/TodoTypeServlet")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TodoTypeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");  
		response.setContentType("application/json");

		String type = request.getParameter("data-type").toUpperCase();
		Long id = Long.parseLong(request.getParameter("id"));
		
		TodoDto dto = new TodoDto();
		dto.setId(id);
		dto.setType(type);
		TodoDao dao = new TodoDao();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		
		int res;
		if(type.contentEquals("DONE")) {
			res = dao.deleteTodo(dto);
			dto.setType("ERASE");
		}
		else {
			res = dao.updataTodo(dto);
			if(type.contentEquals("TODO")) dto.setType("DOING");
			else if(type.contentEquals("DOING")) dto.setType("DONE");
		}
		if(res==1) {
			json = objectMapper.writeValueAsString(dto);
		}
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
	}
}
