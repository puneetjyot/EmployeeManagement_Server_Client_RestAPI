package com.nagarro.EmployeeInfoServer.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.EmployeeInfoServer.dto.EmployeeListDto;
import com.nagarro.EmployeeInfoServer.models.Employee;
import com.nagarro.EmployeeInfoServer.repository.EmployeeRepo;
import com.nagarro.EmployeeInfoServer.utils.HibernateUtil;

public class EmployeeRepoImpl implements EmployeeRepo{

	Session session;

	public EmployeeRepoImpl() {
		
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

	}

	
	@Override
	
	public List<Employee> getEmployeeList() {
		
	

		Criteria cr = session.createCriteria(Employee.class);
		
		//Map<String,String> conditions = new HashMaOp();

		List<Employee> employees=cr.list();
		
		
		return employees;
		
			}


	@Override
	public Employee getEmployee(int code) {

		Criteria cr= session.createCriteria(Employee.class);
		
		Map<String,Integer> conditions = new HashMap();

		conditions.put("employeecode", code);
		
		cr.add(Restrictions.allEq(conditions));

		List<Employee> employees=cr.list();
		
		
		if(cr.list().isEmpty()) {
			System.out.println("Empty list");
		}
		session.close();

		return employees.get(0);
	}


	@Override
	public boolean updateEmployee(Employee employee) {
try {
		System.out.println(employee.getEmployeecode());
		Object obj=session.load(Employee.class,new Integer(employee.getEmployeecode()));
		Employee editemployee=(Employee) obj;
		
		editemployee.setEmployeename(employee.getEmployeename());
		editemployee.setLocation(employee.getLocation());
		editemployee.setEmail(employee.getEmail());
		editemployee.setDateofbirth(employee.getDateofbirth());
		session.getTransaction().commit();
		return true;
	}
	catch(Exception e) {
		System.out.println(e);
		return false;
	}
	}

}
