package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Used to Map a request string should be same as href
@WebServlet("/logout")
public class Logout extends HttpServlet {
	//Request is Coming from button<a> so doGet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Ending a session - logout
		req.getSession().invalidate();
		resp.getWriter().print("<h1 align='center' style='color:red'>Logout Success</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
}
