package com.cruz.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.cruz.dao.IUserRepository;
import com.cruz.model.User;
import com.cruz.util.EntityManagerFactoryUtil;

public class UserRepository implements IUserRepository {

	EntityManager entityManager;

	public UserRepository() {
		EntityManagerFactory entityManagerFactory = EntityManagerFactoryUtil.getEntityManagerFactory();
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		return user;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		User user = findUserById(id);
		if (user != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(user);
			entityManager.getTransaction().commit();
		}
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub

		User userUpdated = null;
		entityManager.getTransaction().begin();
		userUpdated = entityManager.merge(user);
		entityManager.getTransaction().commit();

		return userUpdated;
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(User.class, id);
	}

	@Override
	public User findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		TypedQuery<User> query = entityManager.createQuery("Select u from User u WHERE u.username = :username",
				User.class);
		return query.setParameter("username", userName).getSingleResult();
	}

	@Override
	public List<User> findAllUserByName(String name) {
		// TODO Auto-generated method stub
		TypedQuery<User> query = entityManager.createQuery("Select u from User u WHERE u.name = :name", User.class);
		return query.setParameter("name", name).getResultList();
	}

}
