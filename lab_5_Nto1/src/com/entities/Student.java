package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Student implements java.io.Serializable {
	private static final long serialVersionUID = 1L ;
	
	@Id
	@GeneratedValue
	private long studentId;
	private String studentName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Address studentAddress;

	public Student() {
		super();
	}

	public Student(String studentName, Address studentAddress) {
		super();
		this.studentName = studentName;
		this.studentAddress = studentAddress;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentAddress="
				+ studentAddress + "]";
	}
	
	
}