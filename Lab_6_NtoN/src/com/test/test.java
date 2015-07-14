package com.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.entities.Course;
import com.entities.Student;

public class test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BasePU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		List<Course> courses = new ArrayList<Course>();
		courses.add(new Course("Maths"));
		courses.add(new Course("Computer Science"));
		
		Student student1 = new Student("Eswar",courses);
		Student student2 = new Student("Joe",courses);
		//intéraction avec jpa-hibernate
		em.persist(student1);
		em.persist(student2);
		
		
		tx.commit();
		em.close();
		emf.close();
		System.out.println("OK...!");
	}
}