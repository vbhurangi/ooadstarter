package com.varun.fbproj.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import com.varun.fbproj.model.User;

public class FriendRequestService {

	public static boolean addFriendRequest(String myEmailID,String friendEmailID)
	{
		//this method sends friend request to friendEmailID
		System.out.println("myEmailID="+myEmailID);
		System.out.println("friendEmailID="+friendEmailID);
		
		try {

	      	  DBAccess connect = new DBAccess();
	            boolean check=false;
	            while(check==false)
	            {
	            	check=connect.start();
	            	System.out.println("trying connection for adding friends");
	            }
	            
	            
	            String query = "insert into UserFriends(myEmailID,friendEmailID,status) values (?,?,?)";
	            PreparedStatement ps = connect.con.prepareStatement(query);
	            ps.setString(1,myEmailID);
				ps.setString(2,friendEmailID);
				ps.setString(3,"Pending");
	            
	            ps.executeUpdate();		
				connect.stop();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return false;
		
	}//method ends here
	public static void removeFriendSuggestion(String myEmailID,String friendEmailID)
	{
		//this method removes friend suggested 
	}
	public static void confirmFriendRequest(String myEmailID,String friendEmailID)
	{
		//this method confirms friend request came to me 
	}
	public static void deleteFriendRequest(String myEmailID,String friendEmailID)
	{
		//this method deletes friend request came to me 
	}
	public static ArrayList<User> getAllFriendRequest(String myEmailID,ArrayList<User> al_requests)
	{
		//this method returns all friend requests came to me 
		return al_requests;
	}
	
}//class ends here
