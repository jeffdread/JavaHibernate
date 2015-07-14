package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long courseId;
	private String courseName;
	
	@ManyToMany(mappedBy="courses")
	private List<Student> students = new ArrayList<Student>(0);
	
		
	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}
	public Course() {
		super();
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
