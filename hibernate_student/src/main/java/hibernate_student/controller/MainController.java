package hibernate_student.controller;

import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder.Case;

import hibernate_student.dao.StudentDao;
import hibernate_student.dto.Student;

public class MainController {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter the Choice\n1.Insert Student\n2.Student Update\n3.Student Delete\n4.Student fetch\n5.Student fetchALL");
		int choice=scanner.nextInt();
		Student student=new Student();
		StudentDao dao=new StudentDao();
		switch (choice) {
		case 1:
			
			System.out.println("enter id");
			student.setId(scanner.nextInt());
			
			System.out.println("Enter a age");
			student.setAge(scanner.nextInt());
			
			System.out.println("enter name");
			student.setName(scanner.next());
			
			System.out.println("Enter a Phone");
			student.setPhone(scanner.nextLong());
			
			System.out.println("Enter a Address");
			student.setAddress(scanner.next());
			
			System.out.println("Enter a marks");
			student.setMarks(scanner.nextInt());
			
			System.out.println("Enter percentage");
			student.setPercentage(scanner.nextDouble());
			
			dao.saveStudent(student);
			
			break;
		case 2:{
			System.out.println("enter id");
			student.setId(scanner.nextInt());
			
			System.out.println("Enter a age");
			student.setAge(scanner.nextInt());
			
			System.out.println("enter name");
			student.setName(scanner.next());
			
			System.out.println("Enter a Phone");
			student.setPhone(scanner.nextLong());
			
			System.out.println("Enter a Address");
			student.setAddress(scanner.next());
			
			System.out.println("Enter a marks");
			student.setMarks(scanner.nextInt());
			
			System.out.println("Enter percentage");
			student.setPercentage(scanner.nextDouble());
			
			dao.updateStudent(student.getId(), student);
			
			break;
			
		}
		
		case 3:{
			System.out.println("enter id");
			int id=scanner.nextInt();
			
			
			
			dao.deleteStudent(id);
			break;
			
		}
		case 4:{
			System.out.println("enter id");
			student.setId(scanner.nextInt());
			
			
			dao.fetchbyID(student.getId());
		}
		case 5:{
			dao.fetchAll();
		}

		default:
			break;
		}
	
	}

}
