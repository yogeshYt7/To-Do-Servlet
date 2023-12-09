package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserDto;
import service.UserService;
//Used to Map a request string should be same as action
@WebServlet("/signup")
public class Signup extends HttpServlet {
	//Request is Coming from form so do Post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Receiving values from front end and Loading inside Object
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		//Loading object to save
		UserDto dto=new UserDto();
		dto.setPassword(req.getParameter("password"));
		dto.setName(req.getParameter("name"));
		dto.setAge(Period.between(dob, LocalDate.now()).getYears());
		dto.setDob(dob);
		dto.setEmail(req.getParameter("email"));
		dto.setGender(req.getParameter("gender"));
		dto.setMobile(Long.parseLong(req.getParameter("mobile")));
		
		UserService service=new UserService();
		//Saving user after checking age and email is unique
		if(service.saveUser(dto))
		{
			resp.getWriter().print("<h1 align='center' style='color:green'>Account Created Success</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else {
			resp.getWriter().print("<h1 align='center' style='color:red'>Sorry!! Account cannot be Created</h1>");
			req.getRequestDispatcher("Signup.html").include(req, resp);
		}

	}
}
