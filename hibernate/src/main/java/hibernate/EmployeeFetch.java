package hibernate;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeFetch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarang");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Enter a id");
		Employee employee = entityManager.find(Employee.class, scanner.nextInt());
		System.out.println(employee);

	}
}
