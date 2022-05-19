package com.jbk.entity;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table
public class Registration implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String username;
	private String password;
	private String email;
	private String createdDate;
	private String mobileNo;
	private String fullName;
	private String gender;
	private String country;
	private int age;

	public Registration() {
		super();
	}

	public Registration(int id, String username, String password, String email, String createdDate, String mobileNo,
			String fullName, String gender, String counrty, int age) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.createdDate = createdDate;
		this.mobileNo = mobileNo;
		this.fullName = fullName;
		this.gender = gender;
		this.country = counrty;
		this.age = age;
	}

	@Id
	@GeneratedValue(strategy =AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable = false, unique = true, length = 255)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(nullable = false, unique = false, length = 255)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(nullable = false, unique = true, length = 255)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@DateTimeFormat
	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Column(nullable = false, length = 13)
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(nullable = false, length = 255)
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(nullable = false, length = 20)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(nullable = false, length = 50)
	public String getCounrty() {
		return country;
	}

	public void setCounrty(String counrty) {
		this.country = counrty;
	}

	@Column(nullable = false, length = 10)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", createdDate=" + createdDate + ", mobileNo=" + mobileNo + ", fullName=" + fullName + ", gender="
				+ gender + ", counrty=" + country + ", age=" + age + "]";
	}

}
