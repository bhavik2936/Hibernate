package com.driver;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Faculty;

public class OneToManyAndManyToOneDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		Transaction transaction = null;
		
		Faculty faculty = new Faculty();
		faculty.setFacultyName("John Doe");
		
		Set<Course> courses = new HashSet<Course>();
		Course course1 = new Course();
		course1.setCourseName("Java");
		Course course2 = new Course();
		course2.setCourseName("Android");
		Course course3 = new Course();
		course3.setCourseName("Hibernate");
		
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		faculty.setCourses(courses);

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		session.save(faculty);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
