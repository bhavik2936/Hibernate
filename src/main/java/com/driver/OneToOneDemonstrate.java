package com.driver;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Address;
import com.entity.Customer;

public class OneToOneDemonstrate {

	// returns single user
	Customer GenerateUser() {
		Customer customer = new Customer();
		customer.setCustomerName("John Doe");
		
		Address address = new Address();
		address.setStreetName("11, Park Avenue");
		address.setCity("New York City");
		address.setState("New York");
		
		customer.setAddress(address);
		return customer;
	}
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		Transaction transaction = null;

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

//		session.persist(new OneToOneDemonstrate().GenerateUser());
		
		TypedQuery<Customer> query = session.createQuery("FROM CustomerBean c", Customer.class);
		List<Customer> customerList = query.getResultList();

		for (Customer c : customerList) {
			System.out.println("Customer => " + c.getCustomerId() + " | " + c.getCustomerName());
			Address a = c.getAddress();
			System.out.println("Address => " + a.getAddressId() + " | " + a.getStreetName() + " | " + a.getCity() + " | " + a.getState());
		}
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
