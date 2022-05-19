package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Registration;
import com.jbk.config.HibernateConfiguration;
import com.jbk.entity.Country;
import com.jbk.entity.Employee;

@Repository
public class EmployeeDao implements EmployeeDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	Session session;
	Transaction transaction;

	@Override
	public Registration loginCheck(String email, String password) {

		Criteria criteria;
		Registration reg = null;

		try {
			session = sessionFactory.openSession();
			criteria = session.createCriteria(Registration.class);
			criteria.add(Restrictions.eq("email", email));
			criteria.add(Restrictions.eq("password", password));
			reg = (Registration) criteria.uniqueResult();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reg;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = null;
		Criteria criteria;

		try {

			session = sessionFactory.openSession();
			criteria = session.createCriteria(Employee.class);
			list = criteria.list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee emp = null;
		Criteria criteria;
		try {
			session = sessionFactory.openSession();
			criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("id", id));
			emp = (Employee) criteria.uniqueResult();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;

	}

	@Override
	public String addEmployee(Employee employee) {

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ("Employee " + employee.getName() + " Added Successfully");
	}

	@Override
	public List<Country> getAllCountry() {

		List<Country> list = null;
		Criteria criteria;
		try {
			session = sessionFactory.openSession();
			criteria = session.createCriteria(Country.class);
			list = criteria.list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public String updateEmployee(Employee employee) {

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(employee);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Employee Id : " + employee.getId() + " Updated Successfully";
	}

	@Override
	public String deleteEmployee(int id) {

		Employee employee = null;
		try {
			session = sessionFactory.openSession();
			// start the transaction.
			transaction = session.beginTransaction();
			employee = session.get(Employee.class, id);
			// get student object
			session.delete(employee);
			// employee=session.load(Employee.class,id);
			// commit the transaction
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Employee deleted Successfully";

	}
}
