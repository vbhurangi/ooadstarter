package com.varun.fbproj.resource;

import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.*;
import com.varun.fbproj.model.User;
import com.varun.fbproj.service.SignUpService;

@WebService()
@Path("/user")
public class UserResource {
	
	private SignUpService s1;

	public UserResource() {
		s1 = new SignUpService();
	}
	
	@POST
    @Path("/signup")
	@WebMethod(operationName = "insert")
	@Consumes({MediaType.APPLICATION_JSON})
    public boolean addUser(User user) throws JsonParseException, JsonMappingException, IOException{
		
		System.out.println("Inside sign up resource");
		System.out.println("my dob = "+user.getDate());
		//String output = "POST:Jersey say : " + msg;
		user.setEmailID(user.getEmailID());
		user.setPassword(user.getPassword());
		user.setFname(user.getFname());
		user.setLname(user.getLname());
		user.setDate(user.getDate());
		
		if(s1.checkEmailAlreadyUsed(user.getEmailID()))
		{
			return (s1.addUserService(user));
			
		}
		
		else
		{	
		return false;
		}
	}//adduser method ends here
	
	
}//class ends here
