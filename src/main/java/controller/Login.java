package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import service.UserService;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserService service = new UserService();
		if (service.login(email, password)) {
			UserDao dao=new UserDao();
			req.getSession().setAttribute("user",dao.findByEmail(email));
			resp.getWriter().print("<h1 align='center' style='color:green'>Login Success</h1>");
			req.getRequestDispatcher("Home.jsp").include(req, resp);
		} else {
			resp.getWriter().print("<h1 align='center' style='color:red'>Invalid Credentials</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
	}
}