package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity
public class Student implements java.io.Serializable {
	private static final long serialVersionUID = 1L ;
	
	@Id
	@GeneratedValue
	private long studentId;
	private String studentName;
	
	@OneToOne
//	@JoinColumn(name="ADR_ID")
	@JoinColumn(name="address_Id", referencedColumnName="addressId")
	private Address studentAddress;
	
	public Student() {
		super();
	}	

	public Student(String studentName) {
		super();
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentAddress="
				+ studentAddress + "]";
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
		
}
