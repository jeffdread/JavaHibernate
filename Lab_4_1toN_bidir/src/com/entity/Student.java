package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class Student implements java.io.Serializable {
	private static final long serialVersionUID = 1L ;
	
	@Id
	@GeneratedValue
	private long studentId;
	private String studentName;
	
	@OneToMany(mappedBy="student")
//	(fetch=FetchType.EAGER)
//	@JoinTable(name = "STUD_PHONE", joinColumns = @JoinColumn(name="STUD_ID"), inverseJoinColumns = @JoinColumn(name = "PHONE_ID"))
//	@JoinColumn(name="STUD_ID", referencedColumnName="studentId")
	private List<Phone> studentPhoneNumbers;
	
	public Student() {
		super();
	}	

	

	public Student(String studentName, List<Phone> studentPhoneNumbers) {
		super();
		this.studentName = studentName;
		this.studentPhoneNumbers = studentPhoneNumbers;
	}



	@Override
	public String toString() {
		return "Student [studentName=" + studentName + "]";
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<Phone> getStudentPhoneNumbers() {
		return studentPhoneNumbers;
	}

	public void setStudentPhoneNumbers(List<Phone> studentPhoneNumbers) {
		this.studentPhoneNumbers = studentPhoneNumbers;
	}

	
}