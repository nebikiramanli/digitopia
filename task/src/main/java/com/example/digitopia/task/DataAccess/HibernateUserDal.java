package com.example.digitopia.task.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.digitopia.task.Entities.User;

@Repository
public class HibernateUserDal implements IUserDal {

	private EntityManager entityManager;
	
	@Autowired
	public HibernateUserDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public User getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		String query = String.format("from User Where id = '%s'", id);
		User user = (User) session.createQuery(query, User.class).getSingleResult();
		
		return user;
	}

	@Override
	@Transactional
	public void add(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);
	}

	@Override
	@Transactional
	public void update(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);
		
	}

	@Override
	@Transactional
	public void delete(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(user);
		
	}

	@Override
	@Transactional
	public List<User> getUsersByNormalizedName(String normalizedName) {
		Session session = entityManager.unwrap(Session.class);
		String query = "from User Where normalizedName LIKE '%"+ normalizedName +"%'";
		List<User> users = session.createQuery(query, User.class).getResultList();
		return users;
	}

	@Override
	@Transactional
	public User getUserByEmail(String email) {
		Session session = entityManager.unwrap(Session.class);
		String query = String.format("from User Where email = '%s'", email);
		User user = (User) session.createQuery(query, User.class).getSingleResult();
		return user;
	}

}
