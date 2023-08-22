package hibernate;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeDelete {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarang");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("Enter a ID");
		Employee employee = entityManager.find(Employee.class, scanner.nextInt());

		if (employee != null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();

		} else {
			System.out.println("ID NOT FOUND Enter a VAlid Employee ID! ");
		}
	}

}
