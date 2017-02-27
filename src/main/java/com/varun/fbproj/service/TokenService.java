package com.varun.fbproj.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.varun.fbproj.model.User;

public class TokenService {

	public static void set_token(String jwt,User u1)
	{
        try 
        {
            DBAccess connect = new DBAccess();
            boolean check=false;
            while(check==false)
            {
            	check=connect.start();
            	System.out.println("trying connection for token");
            }
            String query = "insert into User_token(emailID,token_value) values (?,?)";
            PreparedStatement ps = connect.con.prepareStatement(query);
            ps.setString(1,u1.getEmailID());
			ps.setString(2,jwt);
            ps.executeUpdate();
            System.out.println("Token saved in DB");
            check=connect.stop();
            
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
	}
	
}//class ends
