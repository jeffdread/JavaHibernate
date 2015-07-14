package com.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import com.entities.Address;
import com.entities.Student;

public class test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BasePU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Address address1 = new Address("OMR Road","Chennai","TN","600097");
		Student student1 = new Student("Eswar");
		student1.setStudentAddress(address1);
		address1.setStudent(student1);
		
		tx.begin();
		
		//intéraction avec jpa-hibernate
		em.persist(student1);
		em.persist(address1);
		
		Address address12=em.find(Address.class, 1l);
		System.out.println(address12.getStudent());
		
		tx.commit();
		em.close();
		emf.close();
		System.out.println("OK...!");
	}
}