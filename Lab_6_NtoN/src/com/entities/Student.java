package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Student implements java.io.Serializable{
	private static final long serialVersionUID = 1L ;
	
	@Id
	@GeneratedValue
	private long studentId;
	private String studentName;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="STUD_COURS", joinColumns=@JoinColumn(name="STUD_ID"),inverseJoinColumns=@JoinColumn(name="COURS_ID"))
	private List<Course> courses = new ArrayList<Course>(0);
	
	public Student(String studentName, List<Course> courses) {
		super();
		this.studentName = studentName;
		this.courses = courses;
	}

	public Student() {
		super();
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
