package com.test;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.entity.Student;
import com.entity.Phone;

public class test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BasePU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		List<Phone> phoneNumbers = new ArrayList<Phone>();
		Student student = new Student("Eswar");
		Phone phone1 = new Phone("house", "32354353");
		Phone phone2 = new Phone("mobile", "9889343423");
		phoneNumbers.add(phone1);
		phoneNumbers.add(phone2);
		student.setStudentPhoneNumbers(phoneNumbers);
		
		tx.begin();
		
		//intéraction avec jpa-hibernate
		em.persist(student);
		em.persist(phone1);
		em.persist(phone2);
		
		tx.commit();
		em.close();
		
		em = emf.createEntityManager();
		tx = em.getTransaction();
		
		tx.begin();
		student = em.find(Student.class, 1L);
		student.getStudentPhoneNumbers().size();
		tx.commit();
		em.close();
		System.out.println(student.getStudentName());
		for(Phone phone : student.getStudentPhoneNumbers()){
			System.out.println("tel:"+ phone.getPhoneNumber());
		}
		emf.close();
		System.out.println("OK...!");
	}
}