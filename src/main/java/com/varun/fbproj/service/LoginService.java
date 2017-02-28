package com.varun.fbproj.service;

import java.sql.*;

import com.varun.fbproj.model.User;

public class LoginService {

	public static boolean loginUserService(User u)
	{
		
		
		try {

      	  DBAccess connect = new DBAccess();
            boolean check=false;
            while(check==false)
            {
            	check=connect.start();
            	System.out.println("trying connection for login");
            }
            
			PreparedStatement prepStatement = connect.con.prepareStatement("select password,userID from User where emailID = ? ");
			prepStatement.setString(1,u.getEmailID());
			

			ResultSet result = prepStatement.executeQuery();
			if (result != null) {
				while (result.next()) {
					if (result.getString(1).equals(u.getPassword()) ){
						u.setUserID(result.getInt(2));
						System.out.println("Login success");
						return true;
						//System.out.println("YES");
					}
					else{
						System.out.println("Not found");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return false;
        
    }//method ends here
	
}
