package hibernate;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeUpdate {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sarang");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
//		To Update Specigfic Data
//		System.out.println("Enter a ID");
//		Employee  employee=entityManager.find(Employee.class, scanner.nextInt());
//		if (employee!=null) {
//			System.out.println("Enter a NEw Phone no");
//			employee.setPhone(scanner.nextLong());
//			
//			entityTransaction.begin();
//			entityManager.merge(employee);
//			entityTransaction.commit();
//			
//			
//		}
//		else {
//			System.out.println("ID NOT FOUND Enter a VAlid Employee ID! ");
//		}
		

		Employee employee=new Employee();
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
		
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		System.out.println("Update Sccefully");

	}

}
