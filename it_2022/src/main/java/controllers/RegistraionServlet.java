package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Skill;
import models.User;
import repositories.Repository;

@WebServlet("/registration")
public class RegistraionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Repository collection;
 
	public void init(ServletConfig config) throws ServletException {
		collection = Repository.getInstance();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/RegistrationPage.jsp");
		rd.forward(request, response); 
		}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		request.setCharacterEncoding("UTF-8");
		String personalName= request.getParameter("personal-name");
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		String repeatPassword= request.getParameter("repeat-password");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(personalName==null || personalName.isEmpty() || username==null || username.isEmpty() ||
				password==null || password.isEmpty() || !password.equals(repeatPassword)) {
			
			out.print("<p>Не са въведени всички полета или паролите не съвпадат</p>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/RegistrationPage.jsp");
			rd.include(request, response);
		}
		else {
			User user = new User(personalName, username, password);
			if(collection.getUserByUsername(username)==null) {
				
				List<Skill> itSkill = new ArrayList<Skill>();
				itSkill.add(new Skill());
				itSkill.add(new Skill());
				itSkill.add(new Skill());
				itSkill.add(new Skill());
				
				user.setItSkills(itSkill);
				
				List<Skill> personalSkill = new ArrayList<Skill>();
				personalSkill.add(new Skill());
				personalSkill.add(new Skill());
				personalSkill.add(new Skill());
				
				user.setPersonalSkills(personalSkill);
				
				collection.addUser(user);
				out.print("<html><body><p>Успешно регистриран потребител</p></body></html>");
				
				response.sendRedirect("login");
				
				/*RequestDispatcher rd = request.getRequestDispatcher("/LoginPage.jsp");
				rd.forward(request, response);*/
			}
			else {
				out.print("<html><body><p>Потребителското име вече е заето</p></body></html>");
				
				RequestDispatcher rd = request.getRequestDispatcher("/RegistrationPage.jsp");
				rd.include(request, response);
				
			}
		}
	}
}













