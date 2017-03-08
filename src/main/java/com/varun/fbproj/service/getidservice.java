
package com.varun.fbproj.service;

import java.sql.*;

import com.varun.fbproj.model.User;

public class getidservice {

	public static int getuserid(String u)
	{
		
		
		try {

      	  DBAccess connect = new DBAccess();
            boolean check=false;
            while(check==false)
            {
            	check=connect.start();
            	System.out.println("trying connection for login");
        		
            }
            
			PreparedStatement prepStatement = connect.con.prepareStatement("select userID from User where emailID = ? ");
			prepStatement.setString(1,u);
			

			ResultSet result = prepStatement.executeQuery();
			if (result.next()) {
				return result.getInt("userID");
				
			}
		} catch (Exception e) {
				
			e.printStackTrace();
		}
		return  (Integer) null; 
		
        
        
    }//method ends here
	
}
