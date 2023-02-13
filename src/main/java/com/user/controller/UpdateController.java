package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.bo.UserAddBo;
import user.dao.UserDao;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
        pw.println("<link rel='stylesheet' href='css/delet.css'></link>");
		int id=Integer.parseInt(req.getParameter("id"));
				
		String name = req.getParameter("userName");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String dob = req.getParameter("dob");
        String city = req.getParameter("city");
        
        UserAddBo usb =new UserAddBo();
     //   UserAddBo usb =new UserAddBo(id, name, email, mobile, dob, city);
        usb.setId(id);
        usb.setName(name);
        usb.setEmail(email);
        usb.setPhon(mobile);
        usb.setDob(dob);
        usb.setCity(city);
        
        int status=UserDao.update(usb);
        
        if(status>0) {
        	pw.println("<script type=\"text/javascript\">");
			pw.println("alert(\"Record Updated Successfully!\")");
			pw.println("</script>");
			RequestDispatcher rd=req.getRequestDispatcher("ShowListController");
      	    rd.forward(req, response);
      	    
        }

	}

}
