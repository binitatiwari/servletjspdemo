package com.vastika.payroll.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vastika.payroll.dao.UserDao;
import com.vastika.payroll.dao.UserDaoImpl;
import com.vastika.payroll.model.User;
import com.vastika.payroll.service.UserService;
import com.vastika.payroll.service.UserServiceImpl;
import com.vastika.payroll.util.DbUtil;


@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService userService= new UserServiceImpl();
	public static final String USER_FORM="userRegistration.jsp";
	public static final String USER_EDIT_FORM="userEdit.jsp";
	public static final String USER_LIST="userList.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		String action=request.getParameter("action");
		String forward="";
		
		if(action.contentEquals("add_user")) {
			forward=USER_FORM;
		}
		else if(action.equals("List_user")) {
			request.setAttribute("users", userService.getAllUserInfo());
			forward=USER_LIST;
		}
		
		else if(action.equals("delete_user")) {
			//System.out.println("deleted" +request.getParameter("id"));
			int id=Integer.parseInt(request.getParameter("id"));
			userService.deleteUser(id);
			request.setAttribute("users", userService.getAllUserInfo());
			forward=USER_LIST;
		}
		else if(action.equals("edit_user")) {
			int id= Integer.parseInt(request.getParameter("id"));
			System.out.println("edited" +id);
			request.setAttribute("user", userService.getUserInfoById(id));
			forward=USER_EDIT_FORM;
		}
		
		 
		
		RequestDispatcher rd= request.getRequestDispatcher(forward);

		rd.forward(request, response);
	}
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		User user=new User();
		user.setUsername(request.getParameter("uname"));
		user.setPassword(request.getParameter("pass"));
		user.setEmail(request.getParameter("email"));
		user.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-DD");
		try {		
		Date dob= sdf.parse(request.getParameter("dob"));
		user.setDob(dob);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		user.setNationality(request.getParameter("nationality"));
		String [] hobby= request.getParameterValues("hobbies");
		String hobbies="";
		for(String hob : hobby) {
			hobbies=hobbies + hob +",";
		}
		user.setHobbies(hobbies);
		String userId=request.getParameter("id");
		
		if(userId== null || userId.isEmpty()) {
			userService.saveUserInfo(user);
			
		}else {
			user.setId(Integer.parseInt(userId));
			userService.updateUserInfo(user);
		}
		
		
		RequestDispatcher rd= request.getRequestDispatcher("userList.jsp");
		request.setAttribute("users", userService.getAllUserInfo());
		rd.forward(request, response);
	}

}
