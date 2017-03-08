package com.varun.fbproj.resource;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.io.IOException;
import java.util.ArrayList;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.varun.fbproj.model.User;
import com.varun.fbproj.service.getidservice;
import com.varun.fbproj.service.seefriendrequestservice;
@WebService()
@Path("/getid")
public class getidresource {
	
	
	
	@POST
	@Path("/getidval")
	//@WebMethod(operationName = "insert")
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON})
    public User getusersid(String jwt) throws JsonParseException, JsonMappingException, IOException{
		
		
		
		System.out.println("Inside sign up resource");
		User u1 = new User();
		Claims claims = Jwts.parser().setSigningKey("secret".getBytes("UTF-8")).parseClaimsJws(jwt).getBody();
	    System.out.println("Subject: " + claims.getSubject());
	    System.out.println("Expiration: " + claims.getExpiration());
	  String emailID=claims.getSubject();
				
	  int x=getidservice.getuserid(emailID);
		u1.setUserID(x);
			return u1;
		
	}


	/*@POST
	@Path("/seefriend1")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public static ArrayList<User> seefriendrequest(User u) throws JsonParseException, JsonMappingException, IOException{
		System.out.println("yobroimhere");
		int uid=u.getUserID();
	
	return seefriendrequestservice.getrequest(uid);
	
	*/
	}




	  
	   
				
				
		

		
	
	//adduser method ends here
