package com.jbk.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jbk.entity.Country;
import com.jbk.entity.Employee;
import com.jbk.entity.Registration;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {


	@Value("${db.password}")
	private String DB_PASSWORD;

	@Value("${db.url}")
	private String DB_URL;

	@Value("${db.username}")
	private String DB_USERNAME;

	@Value("${hibernate.dialect}")
	private String HIBERNATE_DIALECT;

	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernate_HBM2DDL_sql;

	@Value("${entitymanager.packagesToScan}")
	private String ENTITYMANAGER_PACKAGES_TO_SCAN;

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		return dataSource;

	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		sessionFactory.setDataSource(dataSource());

		sessionFactory.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
		hibernateProperties.put("hibernate.hbm2ddl.auto", hibernate_HBM2DDL_sql);

		sessionFactory.setHibernateProperties(hibernateProperties);
		sessionFactory.setAnnotatedClasses(Employee.class, Country.class, Registration.class);

		return sessionFactory;

	}

}
