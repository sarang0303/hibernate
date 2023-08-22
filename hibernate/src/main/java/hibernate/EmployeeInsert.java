package hibernate;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeInsert {
	public static void main(String[] args) {
		Employee employee = new Employee();

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter id");
		employee.setId(scanner.nextInt());
		System.out.println("enter name");
		employee.setName(scanner.next());
		System.out.println("Enter a Phone");
		employee.setPhone(scanner.nextLong());
		System.out.println("Enter a Address");

		employee.setAddress(scanner.next());
		System.out.println("Enter a Email");
		employee.setEmail(scanner.next());
		System.out.println("Enter a Password");
		employee.setPassword(scanner.next());

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarang");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);

		entityTransaction.commit();
	}

}
