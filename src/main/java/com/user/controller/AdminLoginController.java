package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		PrintWriter pw=res.getWriter();
		
		
		String usern = req.getParameter("user");
        String pass = req.getParameter("pass");
       
        if(pass.equals("admin") && usern.equals("Dipali")) {
        	pw.write("Welcome..You logged in successfully!!");
        	RequestDispatcher rs =req.getRequestDispatcher("adminpage.html");
			rs.forward(req, res);
		}
		else {
			pw.write("Wrong Username or Password!");
			RequestDispatcher rs1 =req.getRequestDispatcher("adminlogin.html");
			rs1.include(req, res);
		}
        }
       
    
	}

