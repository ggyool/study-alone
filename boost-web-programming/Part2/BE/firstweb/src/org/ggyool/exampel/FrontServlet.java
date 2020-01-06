package org.ggyool.exampel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/front")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int diceValue = (int) (Math.random()*6 + 1);
		request.setAttribute("dice", diceValue);
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("/next"); // 반드시 /로 시작해야함
		requestdispatcher.forward(request, response);
	}
}
