package user.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.bo.UserAddBo;
import user.bo.UserBo;


public class UserDao {
	 
	public static Connection getconnection() {
		// con=null;
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/codenera","root", "rootroot");
			
		}catch(Exception e){
			System.out.println("Database Not Connected");
		}
		
		return con;
		
		
	}
	public static int usersignup(UserBo usr) {
		int status=0;
		Connection con=UserDao.getconnection();
		String sql="insert into user(name,email,phon,dob,city) values(?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, usr.getName());
			ps.setString(2, usr.getEmail());
			ps.setString(3, usr.getPhon());
			ps.setString(4, usr.getDob());
			ps.setString(5, usr.getCity());
						
			status = ps.executeUpdate();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return status;
		
	}
	
	public static List<UserAddBo> showlist() {
		List<UserAddBo> list=new ArrayList<UserAddBo>();
		try {
			Connection con=UserDao.getconnection();
			PreparedStatement ps=con.prepareStatement("select * from user");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				UserAddBo ub=new UserAddBo();
				ub.setId(rs.getInt(1));
				ub.setName(rs.getString(2));
				ub.setEmail(rs.getString(3));
				ub.setPhon(rs.getString(4));
				ub.setDob(rs.getString(5));
				ub.setCity(rs.getString(6));
				
				list.add(ub);
				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public static UserAddBo getEmployeeById(int id) {
		 UserAddBo eb= new UserAddBo();
		 
		   try {
		   	
			   Connection con=UserDao.getconnection();
			   String query="select * from user where id=?";
			   
			   PreparedStatement ps=con.prepareStatement(query);
			   ps.setInt(1, id);

			   ResultSet rs=ps.executeQuery();
			   
			   if(rs.next()) {
				   
				   eb.setId(rs.getInt(1));
				   eb.setName(rs.getString(2));
				   eb.setEmail(rs.getString(3));
				   eb.setPhon(rs.getString(4));
				   eb.setDob(rs.getString(5));
				  
				   eb.setCity(rs.getString(6));
				   
			   }
			   
			   
			   
		} catch (Exception e) {
		
			System.out.println(e);
			
		}
		  
		  
		  return eb;
	 }
	   
	
	
	public static int update(UserAddBo usb) {
		int status=0;
		try {
			
			Connection con =UserDao.getconnection();
			
			String query="update user set name=?,email=?,phon=?,dob=?,city=? where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, usb.getName());
			ps.setString(2, usb.getEmail());
			ps.setString(3, usb.getPhon());
			ps.setString(4, usb.getDob());
			ps.setString(5, usb.getCity());
			ps.setInt(6, usb.getId());
			
			status=ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
		
	}
	
public static int delete(int id) {
		
		int status=0;
		  try {
		
			  Connection con=UserDao.getconnection();
			  String query="Delete from user where id=?";
			  PreparedStatement ps=con.prepareStatement(query);
			  ps.setInt(1, id);
			  status=ps.executeUpdate();
			  
		} catch (Exception e) {
		
			   System.out.println(e);
		}
		
		return status;
		
	}
	
}