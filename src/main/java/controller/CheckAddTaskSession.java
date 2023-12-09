package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserDto;

//Used to Map a request string should be same as href
@WebServlet("/session-add-task")
public class CheckAddTaskSession extends HttpServlet {
	//Request is Coming from button<a> so doGet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Checking Session ie, User is Logged in
		UserDto dto = (UserDto) req.getSession().getAttribute("user");
		if (dto == null) {
			resp.getWriter().print("<h1 align='center' style='color:red'>Session Expired, Login Again</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
			req.getRequestDispatcher("AddTask.html").forward(req, resp);
		}
	}
}
