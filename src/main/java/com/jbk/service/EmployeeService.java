package com.jbk.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.EmployeeDao;
import com.jbk.entity.Country;
import com.jbk.entity.Employee;
import com.jbk.entity.Registration;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeDao dao;

	@Override
	public HashMap<String, Object> loginCheck(String email, String password) {

		Registration user = dao.loginCheck(email, password);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		if (user == null) {
			hashMap.put("msg", "Invalid User");
			hashMap.put("user", user);
		} else {
			hashMap.put("msg", "Valid User");
			hashMap.put("user", user);
		}
		return hashMap;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = dao.getAllEmployee();
		return list;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = dao.getEmployeeById(id);
		return employee;
	}

	@Override
	public String addEmployee(Employee employee) {

		return dao.addEmployee(employee);
	}

	@Override
	public List<Country> getAllCountry() {
		List<Country> list = dao.getAllCountry();
		return list;
	}

	@Override
	public String updateEmployee(Employee employee) {
		
		return dao.updateEmployee(employee);
	}

	@Override
	public String deleteEmployee(int id){
		dao.deleteEmployee(id);
		return "Employee deleted Successfully" ;
	}

}
