package com.org.student.model;

public class Student {
	private String stud_id;
	private String stud_no;
	private String fullname;
	private String gender;
	private String telephone;
	private String address;
	private String email;
	private String course_name;
	private String school_yr;
	private String skill_name;
	private String subject_name;
	private String shift;
	
	public Student(String stud_id, String stud_no, String fullname,
			String gender, String telephone, String address, String email,
			String course_name, String school_yr, String skill_name,
			String subject_name, String shift) {
		super();
		this.stud_id = stud_id;
		this.stud_no = stud_no;
		this.fullname = fullname;
		this.gender = gender;
		this.telephone = telephone;
		this.address = address;
		this.email = email;
		this.course_name = course_name;
		this.school_yr = school_yr;
		this.skill_name = skill_name;
		this.subject_name = subject_name;
		this.shift = shift;
	}
	
	public String getStud_id() {
		return stud_id;
	}

	public void setStud_id(String stud_id) {
		this.stud_id = stud_id;
	}

	public String getStud_no() {
		return stud_no;
	}
	public void setStud_no(String stud_no) {
		this.stud_no = stud_no;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getSchool_yr() {
		return school_yr;
	}
	public void setSchool_yr(String school_yr) {
		this.school_yr = school_yr;
	}
	public String getSkill_name() {
		return skill_name;
	}
	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	
	
	
}
