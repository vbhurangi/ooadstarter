package com.varun.fbproj.resource;

import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.*;
import com.varun.fbproj.model.User;
import com.varun.fbproj.service.SignUpService;


@WebService()
@Path("user")
public class UserResource {
	
	private SignUpService s1;

	public UserResource() {
		s1 = new SignUpService();
	}
	
	@POST
    @Path("/signup")
	@WebMethod(operationName = "insert")
	@Consumes({MediaType.APPLICATION_JSON})
    public User addUser(User user) throws JsonParseException, JsonMappingException, IOException{
		
		System.out.println("Inside sign up resource");
		//System.out.println(user.getFname());
		//String output = "POST:Jersey say : " + msg;
		user.setEmailID(user.getEmailID());
		user.setPassword(user.getPassword());
		user.setFname(user.getFname());
		user.setLname(user.getLname());
		if(s1.addUserService(user))
		{
			return user;
		}
		return null;
       
	}//adduser method ends here
	
	
}//class ends here
