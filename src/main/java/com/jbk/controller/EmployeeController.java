package com.jbk.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Country;
import com.jbk.entity.Employee;
import com.jbk.entity.Registration;
import com.jbk.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	// API for Login
	@PostMapping(value = "/login")
	public HashMap<String, Object> loginCheck(@RequestBody Registration registration) {
		return service.loginCheck(registration.getEmail(), registration.getPassword());
	}

	// API for fetch all employee from DB
	@GetMapping(value = "/getallemployee")
	public List<Employee> getAllEmployee() {
		List<Employee> list = service.getAllEmployee();
		return list;
	}

	// API for fetch single employee from DB on the basis of their ID
	@GetMapping(value = "/getempbyid/{id}")
	public Employee getEmployeeById(@PathVariable int id) {

		Employee employee = service.getEmployeeById(id);
		return employee;
	}

	// API for save new employee in DB
	@PostMapping(value = "/addemployee")
	public String addEmployee(@RequestBody Employee employee) {

		return service.addEmployee(employee);
	}

	// API for fetch list of all Country
	@GetMapping(value = "/getallcountry")
	public List<Country> getAllCountry() {
		List<Country> list = service.getAllCountry();
		return list;
	}

	// API for update employee details and save into DB

	@PutMapping(value = "/updateemp")
	public String updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}

	@DeleteMapping(value = "/deleteemp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}

}
