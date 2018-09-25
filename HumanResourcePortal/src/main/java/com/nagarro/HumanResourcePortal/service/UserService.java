package com.nagarro.HumanResourcePortal.service;

import com.nagarro.HumanResourcePortal.model.Manager;

public interface UserService {

	boolean validateUser(Manager manager);

	boolean registerUser(Manager manager);

}
