package com.jbk.dao;

import java.util.List;

import com.jbk.entity.Country;
import com.jbk.entity.Employee;
import com.jbk.entity.Registration;

public interface EmployeeDaoInterface {

	Registration loginCheck(String email, String password);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(int id);

	String addEmployee(Employee employee);

	List<Country> getAllCountry();
	
	String updateEmployee(Employee employee);
	
	String deleteEmployee(int id);

}
