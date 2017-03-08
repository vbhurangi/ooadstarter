package com.varun.fbproj.resource;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.varun.fbproj.model.User;
import com.varun.fbproj.service.seefriendrequestservice;

@Path("/getrequest")

public class seefriendrequestresource {

	@POST

	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public static ArrayList<User> seefriendrequest(User u) throws JsonParseException, JsonMappingException, IOException{
		System.out.println("yobroimhere");
		int uid=u.getUserID();
	
	return seefriendrequestservice.getrequest(uid);
	
	
	}




}
