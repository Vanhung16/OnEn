package edu.poly.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import edu.poly.model.User;

public class UserDao extends AbstractEntityDao<User>{

	public UserDao() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}
	public void ChangePassword(String username, String oldPassword, String newPassword) 
			throws Exception {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		String x = "select u from User u where u.username = :username and u.password = :password ";
		
		try {
			trans.begin();
			
			TypedQuery<User> query = em.createQuery(x, User.class);
			 query.setParameter("username", username);
			 query.setParameter("password", oldPassword);
			 
			 User user = query.getSingleResult();			
			 
			 if(user == null) {
				 throw new Exception("Current password or Username are incorrect");
				 
			 }
			 user.setPassword(newPassword);
			 em.merge(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			
			throw e;
		}finally {
			em.close();
		}
	}
	
}
