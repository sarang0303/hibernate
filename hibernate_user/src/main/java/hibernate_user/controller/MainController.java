package hibernate_user.controller;

import java.util.Scanner;

import hibernate_user.dao.UserDao;
import hibernate_user.dto.User;

public class MainController {
  public static void main(String[] args) {
	  Scanner  scanner=new Scanner(System.in);
	  System.out.println("Enter a choice:\n1.signup \n2.login");
	  int choice=scanner.nextInt();
	  User user=new User();
	  UserDao dao=new UserDao();
	  switch (choice) {
	case 1:
		System.out.println("Enter a id");
		user.setId(scanner.nextInt());
		
		System.out.println("Enter a Name");
		user.setName(scanner.next());
		
		System.out.println("Enter a phone");
		user.setPhone(scanner.nextLong());
		
		System.out.println("Enter a email");
	    user.setEmail(scanner.next());
	    
	    System.out.println("Enter a password");
	    user.setPassword(scanner.next());
	    

	    dao.saveUser(user);
		break;
		
	case 2:{
		System.out.println("Enetr the email");
		String email=scanner.next();
		
		System.out.println("enter the password");
		String password=scanner.next();
		
		boolean result=dao.loginUser(email, password);
		if (result) {
			System.out.println("Login Succefull");
			dao.displayPassword(email);
			System.out.println("Enter the choice\n1.Upadate Password");
			int key =scanner.nextInt();
			switch (key) {
			case 1:
				System.out.println("Enter a facebook");
				user.setFacebook(scanner.next());
				
				System.out.println("Enter a Instagram");
				user.setInstagram(scanner.next());
				
				System.out.println("enter a Twitter");
				user.setTwitter(scanner.next());
				
				System.out.println("Enter a Linkedin");
				user.setLinkedin(scanner.next());
				dao.updatePassword(email, user);
				
				break;

			default:
				break;
			}
			
			
		}
		else
			System.out.println("invalid Credential");
	}

	default:
		break;
	}
	
}
}
