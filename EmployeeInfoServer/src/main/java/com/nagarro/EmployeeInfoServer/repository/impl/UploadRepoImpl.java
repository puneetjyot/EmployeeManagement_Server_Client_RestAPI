package com.nagarro.EmployeeInfoServer.repository.impl;

import java.util.List;

import org.hibernate.Session;

import com.nagarro.EmployeeInfoServer.models.Employee;
import com.nagarro.EmployeeInfoServer.repository.UploadRepo;
import com.nagarro.EmployeeInfoServer.utils.HibernateUtil;

public class UploadRepoImpl implements UploadRepo {

	Session session;
	
	public UploadRepoImpl() {
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
	}
	
	@Override
	public void addlistEmployee(List<Employee> employees) {
		
		
		for(Employee employee:employees)
		{
			try {
			session.save(employee);
			
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		session.getTransaction().commit();
	}

}
