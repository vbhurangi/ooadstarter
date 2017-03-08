
package com.varun.fbproj.resource;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.*;
import com.varun.fbproj.model.User;
import com.varun.fbproj.model.userfriend;
import com.varun.fbproj.service.LoginService;
import com.varun.fbproj.service.LogoutService;
import com.varun.fbproj.service.RetriveService;
import com.varun.fbproj.service.SignUpService;
import com.varun.fbproj.service.TokenService;
import com.varun.fbproj.service.UpdateService;
import com.varun.fbproj.service.getidservice;
import com.varun.fbproj.service.putrequestservice;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
@WebService()
@Path("/putrequest")
public class putfriendrequest {
	
	@POST
	@WebMethod(operationName = "insert")
	@Consumes({MediaType.APPLICATION_JSON})

    public void addUser1(userfriend user) throws JsonParseException, JsonMappingException, IOException{
		System.out.println("userid"+user.getUserID());
		 putrequestservice.putrequest(user.getUserID(),user.getfriendID(),user.getstatusID(),user.getinitiatorID(),user.getreceiverID());
		
			
		
	}
}
	  
	   
				
				
		

		
	
	//adduser method ends here
