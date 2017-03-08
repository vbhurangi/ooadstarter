package com.varun.fbproj.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.varun.fbproj.model.User;

public class seefriendrequestservice {

	//this method searches for all users in database with given fname or lname
	public static ArrayList<User> getrequest(int uid)
	{    
		ArrayList<User> friendrequest = new ArrayList<User>();
		try {

	      	  DBAccess connect = new DBAccess();
	            boolean check=false;
	            while(check==false)
	            {
	            	check=connect.start();
	            	System.out.println("trying connection");
	            }
	            
	            //String[] splited = searchName.split("\\s+");
	            
	            
	            
	            
	            	PreparedStatement prepStatement = connect.con.prepareStatement("select receiverID from userfriend where statusID = ? and initiatorID !=?");
	            	//it searches like %name% like statement of sql
	            	prepStatement.setInt(1,0);
	            	prepStatement.setInt(2, uid);
									
					ResultSet result = prepStatement.executeQuery();
					if (result .next()) {
						while (result.next()) {
							PreparedStatement prepStatement2 = connect.con.prepareStatement("select fname from User where userID = ?");
			            	//it searches like %name% like statement of sql
			            	prepStatement2.setInt(1,result.getInt("receiverID"));
			            	ResultSet result2 = prepStatement2.executeQuery();
						User u_obj=new User();
						u_obj.setFname(result2.getString("fname"));
						//u_obj.setLname(result.getString("lname"));
						u_obj.setUserID(result.getInt("receiverID"));
						//u_obj.setEmailID(result.getString("emailID"));
						friendrequest.add(u_obj);
						
					}
				  }	//if ends
					
	            //for ends here
	            

					
			} catch (Exception e) {
				e.printStackTrace();
			}

		
		return friendrequest;
	}//method ends here
	
	
}//class ends here
