package com.jbk.service;

import java.util.HashMap;
import java.util.List;

import com.jbk.entity.Country;
import com.jbk.entity.Employee;

public interface EmployeeServiceInterface {

	HashMap<String, Object> loginCheck(String email, String password);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(int id);

	String addEmployee(Employee employee);

	List<Country> getAllCountry();

	String updateEmployee(Employee employee);
	
	String deleteEmployee(int id);
}
