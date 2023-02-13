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
 * Servlet implementation class ShowListController
 */
@WebServlet("/ShowListController")
public class ShowListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw = res.getWriter();
	        
	        res.setContentType("text/html");
	    	pw.print("<link rel='stylesheet' href='css/list.css'></link>");
	    	
	        pw.write("<h1 class='de'>All Users List</h1>");
	       
	        pw.write("<a href=\"adminpage.html\" ><h3>Back</h3></a>");
	        pw.print("<body style='background-color:#B0C4DE;'>");
	        pw.print("<table  border='1px' width='100%' padding='30px'> ");
	      
	        pw.print("<tr class='ta1'><th>Id</th><th>Name</th><th>Email</th><th>Phone No.</th><th>DOB</th><th>City</th><th>Update</th><th>Delete</th>");
	        
	        List<UserAddBo> list = UserDao.showlist();
	        for(UserAddBo ub:list) {
	        	pw.print("<tr class='ta'><td>"+ub.getId()+"</td><td>"+ub.getName()+"</td><td>"+ub.getEmail()+"</td><td>"+ub.getPhon()+"</td><td>"+ub.getDob()+"</td><td>"
	        +ub.getCity()+"</td><td>"+"<a href='EditRecordcontroller?id="+ub.getId()+"'>Update </a></td> <td><a href='DeleteController?id="
	        			+ub.getId()+"'> Delete </a></td></tr>"); 

	                pw.println("</tr>");
	        }
	      
	        pw.print("</table>");
	       
	       	}

}
