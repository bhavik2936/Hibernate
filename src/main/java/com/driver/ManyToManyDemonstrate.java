package com.driver;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Hobby;
import com.entity.Person;

public class ManyToManyDemonstrate {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		Transaction transaction = null;
		
		Person p1 = new Person();
		p1.setPersonName("Bvk");
		
		Set<Hobby> hobbies1 = new HashSet<Hobby>();
		Hobby h1 = new Hobby();
		h1.setHobbyName("Travelling");
		Hobby h2 = new Hobby();
		h2.setHobbyName("Chess");
		hobbies1.add(h1);
		hobbies1.add(h2);
		p1.setHobbies(hobbies1);
		
		Person p2 = new Person();
		p2.setPersonName("John");
		
		Set<Hobby> hobbies2 = new HashSet<Hobby>();
		Hobby h3 = new Hobby();
		h3.setHobbyName("Cricket");
		Hobby h4 = new Hobby();
		h4.setHobbyName("Travelling");
		Hobby h5 = new Hobby();
		h5.setHobbyName("Swimming");
		hobbies2.add(h3);
		hobbies2.add(h4);
		hobbies2.add(h5);
		p2.setHobbies(hobbies2);
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.save(p1);
		session.save(p2);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
