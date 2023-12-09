package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserDto;
import service.UserService;
//Used to Map a request string should be same as action
@WebServlet("/login")
public class Login extends HttpServlet {
	//Request is Coming from form so do Post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Receiving values from front end
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserService service = new UserService();
		//Checking if email and password is valid
		if (service.login(email, password)) {
			UserDao dao=new UserDao();
			UserDto dto=dao.findByEmail(email);
			//Adding user to session
			req.getSession().setAttribute("user",dto);
			resp.getWriter().print("<h1 align='center' style='color:green'>Login Success</h1>");
			//Sending tasks to Home.jsp
			req.setAttribute("list", dto.getTasks());
			req.getRequestDispatcher("Home.jsp").include(req, resp);
		} else {
			resp.getWriter().print("<h1 align='center' style='color:red'>Invalid Credentials</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
	}
}
