package com.osuapp.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("course")
public class Course {

	@Id
	public String id; 
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Property("name")
	public String departmentName;
	
	@Property("courseList")
	public List<String> courseList;
	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<String> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<String> courseList) {
		this.courseList = courseList;
	}
}
