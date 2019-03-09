package com.cruz.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.cruz.dao.IAnimalRepository;
import com.cruz.model.Animal;
import com.cruz.util.EntityManagerFactoryUtil;

public class AnimalRepository implements IAnimalRepository {

	EntityManager entityManager;

	public AnimalRepository() {
		EntityManagerFactory entityManagerFactory = EntityManagerFactoryUtil.getEntityManagerFactory();
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public Animal saveAnimal(Animal animal) {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		entityManager.persist(animal);
		entityManager.getTransaction().commit();
		return animal;
	}

	@Override
	public void deleteAnimal(int id) {
		// TODO Auto-generated method stub
		Animal animal = findAnimalById(id);
		if (animal != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(animal);
			entityManager.getTransaction().commit();
		}
	}

	@Override
	public Animal updateAnimal(Animal animal) {
		// TODO Auto-generated method stub
		Animal animalUpdated = null;
		entityManager.getTransaction().begin();
		animalUpdated = entityManager.merge(animal);
		entityManager.getTransaction().commit();

		return animalUpdated;
	}

	@Override
	public Animal findAnimalById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Animal.class, id);
	}

	@Override
	public List<Animal> findAllAnimalByName(String name) {
		// TODO Auto-generated method stub
		TypedQuery<Animal> query = entityManager
				.createQuery("Select a from Animal a WHERE a.name LIKE CONCAT('%',:name,'%')", Animal.class);
		return query.setParameter("name", name).getResultList();
	}

}
