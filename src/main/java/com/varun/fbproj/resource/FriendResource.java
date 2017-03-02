package com.varun.fbproj.resource;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.io.IOException;
import java.util.ArrayList;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.varun.fbproj.model.User;
import com.varun.fbproj.service.GetMyAllFriends;
import com.varun.fbproj.service.SearchFriendService;
import com.varun.fbproj.service.SuggestedFriendService;

import java.util.*;

@WebService()
@Path("/friend")
public class FriendResource {

	@GET
    @Path("/getMyAllFriends")
	@Produces({MediaType.APPLICATION_JSON})
    public static ArrayList<User> getAllMyFriend(@CookieParam("ID") String jwt
    		) throws JsonParseException, JsonMappingException, IOException{
	
		System.out.println("inside get my all friends");
		System.out.println("jwt="+ jwt);
		Claims claims = Jwts.parser()         
			       .setSigningKey("secret".getBytes("UTF-8"))
			       .parseClaimsJws(jwt).getBody();
			    System.out.println("Subject: " + claims.getSubject());
			   // System.out.println("Expiration: " + claims.getExpiration());
			  String myEmailID=claims.getSubject();
		
		ArrayList<User> al_friends=new ArrayList<User>();
         System.out.println("fetching all my friends list");
		
		return GetMyAllFriends.getMyFriends(al_friends,myEmailID);	
	
	}//findMyFriend method ends here
	
	@GET
    @Path("/searchFriend")
	@Consumes({MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON})
	public static ArrayList<User> searchFriend(String friendName)
    	        throws JsonParseException, JsonMappingException, IOException{
	//this method will return all users whose name we enter in find friend input box
		System.out.println("find my friends resource");
		//f1.getFriends(friendName);
	
		ArrayList<User> al_friends=new ArrayList<User>();
        return SearchFriendService.searchFriends(al_friends, friendName);
	 //we need to return list of user objects in json format	
	
	}//searchFriend method ends here
	

	@GET
    @Path("/peopleYouMay_KnowMutualFriends")
	@Produces({MediaType.APPLICATION_JSON})
    public static ArrayList<User> peopleYouMayKnow(@CookieParam("ID") String jwt
    		) throws JsonParseException, JsonMappingException, IOException{
	
		System.out.println("jwt="+ jwt);
		Claims claims = Jwts.parser()         
			       .setSigningKey("secret".getBytes("UTF-8"))
			       .parseClaimsJws(jwt).getBody();
			    System.out.println("Subject: " + claims.getSubject());
			   // System.out.println("Expiration: " + claims.getExpiration());
			  String myEmailID=claims.getSubject();
		
		ArrayList<User> al_friends=new ArrayList<User>();
		ArrayList<User> al_mutual_friends=new ArrayList<User>();
         System.out.println("fetching all my friends ke friends list");
		al_friends=GetMyAllFriends.getMyFriends(al_friends,myEmailID);
		
		for(int i=0;i<al_friends.size();i++)
		{
			String e1=al_friends.get(i).getEmailID();
			ArrayList<User> temp=new ArrayList<User>();
			temp=GetMyAllFriends.getMyFriends(temp,e1);
			al_mutual_friends=FriendResource.union(temp, al_mutual_friends);
		}
		return al_mutual_friends;	
	
	}//people you may know method ends here
	
	//for adding 2 arraylist of friends
	public static <User> ArrayList<User> union(ArrayList<User> list1, ArrayList<User> list2) {
        Set<User> set = new HashSet<User>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<User>(set);
    }//union method ends here
	
	
	@GET
    @Path("/suggestedFriends")
	@Produces({MediaType.APPLICATION_JSON})
    public static ArrayList<User> getSuggestedFriends(@CookieParam("ID") String jwt
    		) throws JsonParseException, JsonMappingException, IOException{
	
		System.out.println("jwt="+ jwt);
		Claims claims = Jwts.parser()         
			       .setSigningKey("secret".getBytes("UTF-8"))
			       .parseClaimsJws(jwt).getBody();
			    System.out.println("Subject: " + claims.getSubject());
			   // System.out.println("Expiration: " + claims.getExpiration());
			  String myEmailID=claims.getSubject();
		
		ArrayList<User> al_friends=new ArrayList<User>();
         System.out.println("fetching all my suggested friends list");

		
		return SuggestedFriendService.getSuggestedFriends(al_friends, myEmailID);	
	
	}//suggestedFriend method ends here

	
	
	
}//class ends here
