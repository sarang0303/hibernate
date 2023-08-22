

package hibernate_student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import hibernate_student.dto.Student;

public class StudentDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sarang");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
		
	}
	
	public void saveStudent(Student student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		
	}
	public void updateStudent(int id, Student student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student studentdb=entityManager.find(Student.class, id);
		if (studentdb!=null) {
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
		} else {
			System.out.println("Id NOT FOUND");

		}
		
	}
     public void deleteStudent(int id) {
    	 EntityManager entityManager=getEntityManager();
    	 EntityTransaction entityTransaction=entityManager.getTransaction();
    	 Student student = entityManager.find(Student.class, id);
    	 if (student != null) {
 			entityTransaction.begin();
 			entityManager.remove(student);
 			entityTransaction.commit();

 		} else {
 			System.out.println("Student with given id "+id+"is not found");
 		}
		
	}
     
     public void fetchbyID(int id) {
    	 EntityManager entityManager=getEntityManager();
    	Student student = entityManager.find(Student.class,id);
 		System.out.println(student);
    	 
		
	}
     public void fetchAll() {
    	 EntityManager entityManager=getEntityManager();
    	 Query query=	entityManager.createQuery("SELECT e FROM Student e");
    		List<Student> students= query.getResultList();
    		System.out.println(students);
    	 
		
	}
}
