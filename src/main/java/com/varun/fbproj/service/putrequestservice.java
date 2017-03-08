
package com.varun.fbproj.service;

import java.sql.*;

import com.varun.fbproj.model.User;

public class putrequestservice {

	public static void putrequest(int u1,int u2,int s1,int i1,int r1)
	{
		System.out.println("u1"+u1+"u2"+u2+"i1"+i1);
		
		try {

      	  DBAccess connect = new DBAccess();
            boolean check=false;
            while(check==false)
            {
            	check=connect.start();
            	System.out.println("trying connection for login");
        		
            }
            
            String query = "insert into userfriend(userID,friendID,statusID,initiatorID,receiverID) values (?,?,?,?,?)";
            PreparedStatement ps = connect.con.prepareStatement(query);
           
			ps.setInt(1,u1);
			ps.setInt(2,u2);
			ps.setInt(3, s1);
			ps.setInt(4,i1);
			ps.setInt(5,r1);
            ps.executeUpdate();
            System.out.println("yoho");

			//ResultSet result = ps.executeQuery();
			//if (result.next()) {
			System.out.println("Friend request sent");	
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
        
        
    }//method ends here
	
}
