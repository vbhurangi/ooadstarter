package com.varun.fbproj.resource;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.POST;
import javax.xml.bind.DatatypeConverter;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import java.security.Key;
import java.util.*;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.*;
import com.varun.fbproj.model.User;
import com.varun.fbproj.service.SignUpService;
import com.varun.fbproj.service.TokenService;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
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
	@Produces({MediaType.TEXT_PLAIN})
    public String addUser(User user) throws JsonParseException, JsonMappingException, IOException{
		
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
			if(s1.addUserService(user))
			{
				
	           String token= createJWT(user.getEmailID());
	           System.out.println("jwt is == "+ token); 
	           TokenService.set_token(token, user);
	           return token; 
	           // Return the token on the response
	            //return Response.ok(token).build();
				
				
			}

		}
		return null;
	}//adduser method ends here
	
	
	/*  validation of token
	 * String jwt = <jwt passed in from above>
Jws<Claims> claims = Jwts.parser()
  .setSigningKey("secret".getBytes("UTF-8"))
  .parseClaimsJws(jwt)
String scope = claims.getBody().get("scope")
assertEquals(scope, "self groups/admins");
	 * */
	
	//Sample method to construct a JWT
	private String createJWT(String emailID) {
	 
		String jwt="";
		try {
			jwt = Jwts.builder()
					  .setSubject(emailID)
					  .setExpiration(new Date(1300819380))
					  .claim("shubham", "varun Token Man")
					  .signWith(
					    SignatureAlgorithm.HS256,
					    "secret".getBytes("UTF-8")
					  )
					  .compact();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		return jwt;
	}
	

	
}//class ends here