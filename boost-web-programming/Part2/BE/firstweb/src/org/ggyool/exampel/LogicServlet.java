package org.ggyool.exampel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogicServlet
 */

@WebServlet({"/logic/*", "/logic2"})
public class LogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer na = (int)(Math.random() * 100 + 1);
		Integer nb = (int)(Math.random() * 100 + 1);
		//request.setAttribute("na", na);
		//request.setAttribute("nb", nb);
		//RequestDispatcher requestdispatcher = request.getRequestDispatcher("/result.jsp");
		//requestdispatcher.forward(request, response);
		
		HttpSession session = request.getSession();
		session.setAttribute("na", na);
		session.setAttribute("nb", nb);
		response.sendRedirect("/firstweb/result.jsp");
	}
}
