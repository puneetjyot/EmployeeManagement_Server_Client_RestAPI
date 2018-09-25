package com.nagarro.HumanResourcePortal.service.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nagarro.HumanResourcePortal.constant.Constant;
import com.nagarro.HumanResourcePortal.model.Manager;
import com.nagarro.HumanResourcePortal.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public boolean validateUser(Manager manager) {

		Client client = ClientBuilder.newClient();

		WebTarget target=client.target(Constant.BASE_URL);
		Response response=target.path("login").request(MediaType.APPLICATION_JSON).post(Entity.entity(manager, MediaType.APPLICATION_JSON));
		

		String isValid=response.readEntity(String.class);
		
		
		 
		if(isValid.equals("true")) {
		return true;
	}
		else {
			return false;
		}
	}

	@Override
	public boolean registerUser(Manager manager) {
		Client client = ClientBuilder.newClient();

		WebTarget target=client.target(Constant.BASE_URL);
		
		Response response=target.path("register").request(MediaType.APPLICATION_JSON).post(Entity.entity(manager, MediaType.APPLICATION_JSON));
		
		String isAdded=response.readEntity(String.class);
		
		if(isAdded.equals("true")) {
			return true;
		}
		
		return false;
	}

}
