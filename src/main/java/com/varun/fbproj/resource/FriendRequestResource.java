package com.varun.fbproj.resource;

import java.io.IOException;
import java.util.ArrayList;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.varun.fbproj.model.User;


@WebService()
@Path("/friendRequest")
public class FriendRequestResource {
	
	@POST
    @Path("/addFriend")
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.TEXT_PLAIN})
    public static void addFriendRequest(@CookieParam("ID") String jwt,String friendEmailID
    		) throws JsonParseException, JsonMappingException, IOException{
		
		
		
		
	}//method ends here
	
	
	@DELETE
    @Path("/removeFriend")
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.TEXT_PLAIN})
    public static void removeFriendSuggested(@CookieParam("ID") String jwt,String friendEmailID
    		) throws JsonParseException, JsonMappingException, IOException{
		
		
		
		
	}//method ends here
	
	@POST
    @Path("/confirmRequest")
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.TEXT_PLAIN})
    public static void confirmFriendRequest(@CookieParam("ID") String jwt,String friendEmailID
    		) throws JsonParseException, JsonMappingException, IOException{
		
		
		
		
	}//method ends here
	
	@DELETE
    @Path("/deleteRequest")
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.TEXT_PLAIN})
    public static void deleteFriendRequest(@CookieParam("ID") String jwt,String friendEmailID
    		) throws JsonParseException, JsonMappingException, IOException{
		
		
		
		
	}//method ends here
	
	
	@GET
    @Path("/giveMyRequests")
	@Produces({MediaType.APPLICATION_JSON})
    public static ArrayList<User> getMyALLRequests(@CookieParam("ID") String jwt,String friendEmailID
    		) throws JsonParseException, JsonMappingException, IOException{
		//it returns all friend requests which came to me
		ArrayList<User> al_requestList=new ArrayList<User>();
		
		return al_requestList;
	}//method ends here
	
	

}//class ends
