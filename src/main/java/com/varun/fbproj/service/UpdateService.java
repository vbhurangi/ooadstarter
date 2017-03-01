package com.varun.fbproj.service;

import java.sql.PreparedStatement;

import com.varun.fbproj.model.User;

public class UpdateService {

	public static boolean UpdateUserService(User u1)
	{

        try 
        {
        	  DBAccess connect = new DBAccess();
              boolean check=false;
              while(check==false)
              {
              	check=connect.start();
              	System.out.println("trying connection in update");
              }
            String query = "UPDATE User SET "
            		+ "mob_no=?,college=?,placeOfWork=?,"
            		+ "hometown=?,cityOfWork=?,highschool=? where emailID = ?";
           
            PreparedStatement ps = connect.con.prepareStatement(query);
            //ResultSet rs = stmt.getGeneratedKeys();
            
            //ps.setInt(1,110);
           
			//ps.setString(1,u1.getDate());
			ps.setString(1,u1.getMob_no());
			ps.setString(2,u1.getCollege());
			ps.setString(3,u1.getPlaceOfWork());
			ps.setString(4, u1.getHometown());
			ps.setString(5,u1.getCityOfWork());
			ps.setString(6, u1.getHighschool());
			ps.setString(7,u1.getEmailID());
			
			ps.executeUpdate();
			check=connect.stop();
            return true;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        return false;
    }//update method ends here
	
	
}//class ends here
