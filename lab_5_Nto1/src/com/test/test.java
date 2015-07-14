package com.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.entities.Address;
import com.entities.Student;

public class test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BasePU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Address address = new Address("OMR Road","Chennai","TN", "600097");
		//cascade = all - pas besoin de em.persist(address)
		
		//intéraction avec jpa-hibernate
		Student student1 = new Student("Eswar", address);
		Student student2 = new Student("Joe", address);
		em.persist(student1);
		em.persist(student2);
		
		tx.commit();
		em.close();
		emf.close();
		System.out.println("OK...!");
	}
}