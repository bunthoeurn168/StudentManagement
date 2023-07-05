package com.org.student.model;

public class Course {
	private String course_name;
	private String description;
	public Course(String course_name, String description) {
		super();
		this.course_name = course_name;
		this.description = description;
	}
	
	public Course(String course_name) {
		super();
		this.course_name = course_name;
	}

	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
