package com.varun.fbproj.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.varun.fbproj.model.User;

public class SuggestedFriendService {

	public static ArrayList<User> getSuggestedFriends(ArrayList<User> al_friends,String myEmailID)
	{
		
		try {

	      	  DBAccess connect = new DBAccess();
	            boolean check=false;
	            while(check==false)
	            {
	            	check=connect.start();
	            	System.out.println("trying connection for suggested friends");
	            }
	            
	            
	            PreparedStatement prepStatement = connect.con.prepareStatement("select u2.emailID from User u1,User u2 where u1.emailID=? and u1.emailID!=u2.emailID and (u1.college=u2.college or u1.hometown=u2.hometown or u1.highschool=u2.highschool)");
				
				prepStatement.setString(1,myEmailID);
				ResultSet result = prepStatement.executeQuery();
				
				if (result .next()) {
					while (result.next()) {
				
					String e1=result.getString("emailID");
					User u_obj=new User();	
					u_obj=RetriveService.getUserAllData(e1);				
					//adding user objects of my suggested to arraylist
					al_friends.add(u_obj);
					}
				}//if ends	
				
				/*if (result .next()) {
					while (result.next()) {
				
					String e1=result.getString("emailID");
					
					PreparedStatement ps1 = connect.con.prepareStatement("select u2.friendEmailID from User u1,UserFriends u2 where u1.emailID=? and u2.friendEmailID=? and u1.emailID!=u2.friendEmailID and u2.myEmailID=u1.emailID and u2.status not like 'Accepted' ");
					ps1.setString(1,myEmailID);
					ps1.setString(2,e1);
					
					ResultSet result1 = prepStatement.executeQuery();
				
		             if(result1.next()) {
		            	 while (result1.next()) {
		                System.out.println("suggest this friend. Not a friend already");
		            	String e3=result1.getString("friendEmailID");
		            	User u_obj=new User();	
						u_obj=RetriveService.getUserAllData(e3);				
						//adding user objects of my suggested to arraylist
						al_friends.add(u_obj);
		               }//inner while ends
		            }//inner if ends 	
				}
			  }	//if ends	*/
				connect.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}

		
		return al_friends;
	}
	
	
}//class ends here
