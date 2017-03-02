package com.varun.fbproj.service;

import java.util.ArrayList;

import com.varun.fbproj.model.User;

public class FriendRequestService {

	public static void addFriendRequest(String myEmailID,String friendEmailID)
	{
		//this method sends friend request to friendEmailID
	}
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
