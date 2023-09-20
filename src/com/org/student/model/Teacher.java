package com.org.student.model;

public class Teacher {
	private String id;
	private String name;
	private String password;
	private String gender;
	private String email;
	private String telephone;
	private String address;
	private String dob;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(String id, String name, String password, String gender,
			String email, String telephone, String address, String dob) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
		this.dob = dob;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	
	
	
	
	
}
