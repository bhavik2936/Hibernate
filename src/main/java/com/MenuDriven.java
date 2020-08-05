package com;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.bean.UserBean;

public class MenuDriven {

	public static void printUser(UserBean userBean) {
		System.out.println("User ID: " + userBean.getUserId());
		System.out.println("Name: " + userBean.getName());
		System.out.println("Email: " + userBean.getEmail());
		System.out.println();
	}

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null;

		Scanner sc = new Scanner(System.in);
		Integer choice = new Integer(0);
		String temp = null;

		while (true) {
			System.out.println("Press 1 for Add User");
			System.out.println("Press 2 for Update User details");
			System.out.println("Press 3 for Print User details");
			System.out.println("Press 4 for Print all Users");
			System.out.println("Press 5 for Delete User");
			System.out.println("Press 0 to exit");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				session = sessionFactory.openSession();
				UserBean user = new UserBean();

				System.out.println("Enter Name");
				temp = sc.next();
				user.setName(temp);
				System.out.println("Enter Email");
				temp = sc.next();
				user.setEmail(temp);
				System.out.println("Enter Password");
				temp = sc.next();
				user.setPassword(temp);

				if (session.save(user) != null) {
					System.out.println("User Added\n");
				} else {
					System.out.println("Couldn't Add User\n");
				}
				session.close();
				break;
			case 2:
				session = sessionFactory.openSession();

				System.out.println("Enter User ID");
				Integer userUpdateId = sc.nextInt();
				UserBean userUpdate = session.createQuery("FROM UserBean WHERE userId = :userId", UserBean.class)
						.setParameter("userId", userUpdateId).getSingleResult();
				printUser(userUpdate);

				System.out.println("Enter Name");
				temp = sc.next();
				userUpdate.setName(temp);
				System.out.println("Enter Email");
				temp = sc.next();
				userUpdate.setEmail(temp);
				System.out.println("Enter Password");
				temp = sc.next();
				userUpdate.setPassword(temp);

				Transaction transactionUpdate = session.beginTransaction();
				try {
					session.update(userUpdate);
					transactionUpdate.commit();
					System.out.println("User Updated\n");
				} catch (Exception e) {
					e.printStackTrace();
					transactionUpdate.rollback();
					System.out.println("Couldn't Update User\n");
				} finally {
					session.close();
				}
				break;
			case 3:
				session = sessionFactory.openSession();

				System.out.println("Enter User ID");
				Integer userSelectId = sc.nextInt();
				UserBean userSelect = session.createQuery("FROM UserBean WHERE userId = :userId", UserBean.class)
						.setParameter("userId", userSelectId).getSingleResult();
				printUser(userSelect);

				break;
			case 4:
				session = sessionFactory.openSession();
				List<UserBean> users = session.createQuery("FROM UserBean", UserBean.class).getResultList();

				for (UserBean userLoop : users) {
					printUser(userLoop);
				}

				session.close();
				break;
			case 5:
				session = sessionFactory.openSession();

				System.out.println("Enter User ID");
				Integer userDeleteId = sc.nextInt();
				UserBean userDelete = new UserBean();
				userDelete.setUserId(userDeleteId);
//				System.out.println(session.createQuery("FROM UserBean WHERE userId = :userId").setParameter("userId", userDeleteId).getSingleResult().getClass());

				Transaction transactionDelete = session.beginTransaction();
				try {
					session.delete(userDelete);
					transactionDelete.commit();
					System.out.println("User Deleted\n");
				} catch (Exception e) {
					transactionDelete.rollback();
					System.out.println("Couldn't Delete User\n");
				} finally {
					session.close();
				}

				session.close();
				break;
			case 0:
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice\n");
				break;
			}
		}
	}
}
