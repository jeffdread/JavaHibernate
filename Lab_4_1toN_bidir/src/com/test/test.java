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
		
				
		tx.begin();
		
		List<Phone> phoneNumbers = new ArrayList<Phone>();
		Phone phone1 = new Phone("house", "32354353");
		Phone phone2 = new Phone("mobile", "9889343423");
		phoneNumbers.add(phone1);
		phoneNumbers.add(phone2);
		
		em.persist(phone1);
		em.persist(phone2);
		
		Student student = new Student("Eswar",phoneNumbers);
		phone1.setStudent(student);
		phone2.setStudent(student);
		//intéraction avec jpa-hibernate
		em.persist(student);
		
		tx.commit();
		em.close();
				
		emf.close();
		System.out.println("OK...!");
	}
}