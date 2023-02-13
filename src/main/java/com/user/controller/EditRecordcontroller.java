package com.user.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.bo.UserAddBo;
import user.dao.UserDao;

/**
 * Servlet implementation class EditRecordcontroller
 */
@WebServlet("/EditRecordcontroller")
public class EditRecordcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRecordcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	res.setContentType("text/html");
	 PrintWriter pw=res.getWriter();
	
     pw.println("<link rel='stylesheet' href='css/update.css'></link>");
     String id=req.getParameter("id");
      
     int eid= Integer.parseInt(id);
   
     UserAddBo eb= UserDao.getEmployeeById(eid);
   
  
    pw.write("<div class='container'>"); 
    pw.write(" <img src=\"Images/co.jpg\" alt=\"Snow\" style=\"width:100%\" position='relative'>");
	pw.print("<form  action='UpdateController' method='get' class='registr'>");
    pw.write(" <h2 class=\"regi\">Update Fields</h2>");
	pw.print("<table class='ta'>");
	
	pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
	pw.print("<tr><td>Name: </td><td><input type='text' name='userName' value='"+eb.getName()+"'/></td></tr>");
  	pw.print("<tr><td>Email: </td><td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
  	pw.print("<tr><td>Phone:</td><td><input type='text' name='mobile' value='"+eb.getPhon()+"'/></td></tr>");
	pw.print("<tr><td>Date of Birth: </td><td><input type='text' name='dob' value='"+eb.getDob()+"'/></td></tr>");
  	pw.print("<tr><td>City : </td><td><input type='text' name='city' value='"+eb.getCity()+"'/></td></tr>");
  
  	pw.print("<tr><td><b><input class= 'subbtn' type='submit' value='Update'></b></td></tr>"); 
   
  	pw.print("</table>");
	
	pw.print("</form>");
	pw.print("</div>");


}


}




