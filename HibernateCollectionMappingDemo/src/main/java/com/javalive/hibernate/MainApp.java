package com.javalive.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.javalive.entity.Address;
import com.javalive.entity.UserDetails;

public class MainApp {

	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();//Create user object
		user1.setUserName("First Last"); //Set user name

		Address address1 = new Address(); // create first embedded object address
		address1.setStreet("First Street");
		address1.setCity("First City");
		address1.setState("First State");
		address1.setPincode("First Pin");

		Address address2 = new Address(); // create second embedded object address
		address2.setStreet("Second Street");
		address2.setCity("Second City");
		address2.setState("Second State");
		address2.setPincode("Second Pin");
		//adding addresses object to the list of address
		user1.getLisOfAddresses().add(address1);
		user1.getLisOfAddresses().add(address2);
		
		UserDetails user2 = new UserDetails();//Create user object
		user2.setUserName("Second Last"); //Set user name

		Address address3 = new Address(); // create first embedded object address
		address3.setStreet("Third Street");
		address3.setCity("Third City");
		address3.setState("Third State");
		address3.setPincode("Third Pin");

		Address address4 = new Address(); // create second embedded object address
		address4.setStreet("Fourth Street");
		address4.setCity("Fourth City");
		address4.setState("Fourth State");
		address4.setPincode("Fourth Pin");
		//adding addresses object to the list of address
		user2.getLisOfAddresses().add(address3);
		user2.getLisOfAddresses().add(address4);
		
		try {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession(); //create session object from the session factory
		session.beginTransaction(); //initialize the transaction object from session
		session.save(user1); // save the user
		session.save(user2); // save the user
		session.getTransaction().commit(); //commit the transaction
		System.out.println("Operation complated successfully!!!!!!!!!!!!");
		session.close(); //closing session
		}
		catch(HibernateException ex) {
			ex.printStackTrace();
		}
		finally {
			HibernateUtil.shutdown();
		}
	}
}
