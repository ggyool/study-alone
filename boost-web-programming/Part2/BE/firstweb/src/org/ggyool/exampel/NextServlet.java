package org.ggyool.exampel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NextServlet
 */
@WebServlet("/next")
public class NextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
        out.println("<head><title>form</title></head>");
        out.println("<body>");
		
        
		int len = (int) request.getAttribute("dice");
		for(int i=0; i<len; ++i) {
			out.print("<br>hello");
		}
		out.println("</body>");
		out.println("</html>");
	}



}
