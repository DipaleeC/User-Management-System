package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.bo.UserBo;
import user.dao.UserDao;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


		PrintWriter pw = res.getWriter();
       
        res.setContentType("text/html");
            
        pw.println("<link rel='stylesheet' href='css/regi.css'></link>");
        String name = req.getParameter("userName");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String dob = req.getParameter("dob");
        String city = req.getParameter("city");
             
        UserBo usr= new UserBo(name, email, mobile, dob, city);
        
            if(UserDao.usersignup(usr)==1) {
            	
            	pw.println("<img src='Images/squ.jpg' alt='Snow' style='width:100%' class='im'>");
                pw.println("<h1 class='re'><b>Record Registered Successfully.....!</b></h1><br><br>");
            
                pw.println("<a href=\"index.html\" ><button type='submit' class='rbt1'><h4>Homepage</h4></button></a>");
                pw.println("<a href=\"register.html\" ><button type='submit' class='rbt11'><h4>Registration Form</h4></button></a>");
            }else {
                pw.println("Record Not Registered...Try Again!");
                RequestDispatcher rs=req.getRequestDispatcher("RegisterController");
                rs.include(req, res);
            }
        
     
        pw.close();
	}

}
