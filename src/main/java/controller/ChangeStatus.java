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
//Mapping url
@WebServlet("/change-status")
public class ChangeStatus extends HttpServlet {
	//Request is from <a> so doGet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Checking Session
		UserDto dto = (UserDto) req.getSession().getAttribute("user");
		if (dto == null) {
			resp.getWriter().print("<h1 align='center' style='color:red'>Session Expired, Login Again</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
			//Taking id from url
			int id = Integer.parseInt(req.getParameter("id"));
			//Changing status
			UserService service = new UserService();
			service.changeStatus(id);
			//Update Session
			UserDao dao=new UserDao();
			UserDto dto2=dao.findById(dto.getId());
			req.getSession().setAttribute("user", dto2);
			
			resp.getWriter().print("<h1 align='center' style='color:green'>Status Changed Success</h1>");
			//sending updated data
			req.setAttribute("list", dto2.getTasks());
			req.getRequestDispatcher("Home.jsp").include(req, resp);
		}
	}
}