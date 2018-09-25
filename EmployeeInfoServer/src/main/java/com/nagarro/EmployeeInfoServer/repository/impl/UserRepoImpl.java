package com.nagarro.EmployeeInfoServer.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.EmployeeInfoServer.models.Manager;
import com.nagarro.EmployeeInfoServer.repository.UserRepo;
import com.nagarro.EmployeeInfoServer.utils.HibernateUtil;

public class UserRepoImpl implements UserRepo {
	Session session;

	public UserRepoImpl() {
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

	}

	@Override
	public boolean validUser(Manager manager) {
		List<Manager> aliens=new ArrayList<>();

		Criteria cr = session.createCriteria(Manager.class);
		
		Map<String,String> conditions = new HashMap();
		
		conditions.put("username",manager.getUsername());
		conditions.put("password",manager.getPassword());

		cr.add(Restrictions.allEq(conditions));
	  
		 if(!cr.list().isEmpty()) {
			 return true;
		 }
		return false;
	}

	@Override
	public boolean addUser(Manager manager) {

		try {
		Manager addmanager=new Manager();
		addmanager.setUsername(manager.getUsername());
		addmanager.setPassword(manager.getPassword());
		session.save(addmanager);
		session.getTransaction().commit();
		
		return true;
	}
		catch(Exception e) {
	System.out.println(e);
			return false;
		}
}
}
