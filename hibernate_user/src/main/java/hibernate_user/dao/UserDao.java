package hibernate_user.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_user.dto.User;

public class UserDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarang");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveUser(User user) {

		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

	}

	public boolean loginUser(String email, String password) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=?1");
		query.setParameter(1, email);
		try {
			User user = (User) query.getSingleResult();
			String dbpassword = user.getPassword();

			if (dbpassword.equals(password)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("Invalid email");
		}
		return false;
	}

	public void displayPassword(String email) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=?1");
		query.setParameter(1, email);
		User user = (User) query.getSingleResult();
		System.out.println("The save password are :");
		System.out.println("facebook : " + user.getFacebook());
		System.out.println("Instagram :" + user.getInstagram());
		System.out.println("Twitter" + user.getTwitter());
		System.out.println("Linkedin :" + user.getLinkedin());
	}

	public void updatePassword(String email, User user) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=?1");
		query.setParameter(1, email);
		User dbuser = (User) query.getSingleResult();
		if (dbuser != null) {
			user.setId(dbuser.getId());
			user.setName(dbuser.getName());
			user.setPhone(dbuser.getPhone());
			user.setEmail(dbuser.getEmail());
			user.setPassword(dbuser.getPassword());

			entityTransaction.begin();
			entityManager.merge(user);
			entityTransaction.commit();
		} else {

		}
	}

}
