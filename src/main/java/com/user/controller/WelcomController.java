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
 * Servlet implementation class WelcomController
 */
@WebServlet("/WelcomController")
public class WelcomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		
		PrintWriter pw = res.getWriter();
		
		if(req.getParameter("user") == null) {
			RequestDispatcher rs =req.getRequestDispatcher("adminlogin.html");
			rs.forward(req, res);
		}
		else {
			RequestDispatcher rs1 =req.getRequestDispatcher("register.html");
			rs1.forward(req, res);
		}
		}

}
