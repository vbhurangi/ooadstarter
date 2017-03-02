package com.varun.fbproj.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.varun.fbproj.model.User;

public class IsMyFriendService {

	public static boolean isMyFriend(String emailID1,String emailID2)
	{
		
		try {

	      	  DBAccess connect = new DBAccess();
	            boolean check=false;
	            while(check==false)
	            {
	            	check=connect.start();
	            	System.out.println("trying connection");
	            }
	           // "select * from UserFriends where myEmailID="varun@gmail.com" and status="Accepted""
				PreparedStatement prepStatement = connect.con.prepareStatement("select * from UserFriends "
						+ "where myEmailID = ? and friendEmailID=?");
				prepStatement.setString(1,emailID1);
				prepStatement.setString(2,emailID2);
				
				ResultSet result = prepStatement.executeQuery();
				if (result.next()) {
					System.out.println("yes he is my friend");
					return true;
					
				}	//if ends	
			} catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}
	
}//class ends here