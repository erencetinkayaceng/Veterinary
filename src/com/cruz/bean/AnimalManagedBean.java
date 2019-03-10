package com.cruz.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.cruz.dao.IAnimalRepository;
import com.cruz.dao.IUserRepository;
import com.cruz.dao.impl.AnimalRepository;
import com.cruz.dao.impl.UserRepository;
import com.cruz.model.Animal;
import com.cruz.model.User;

@ManagedBean
@SessionScoped
public class AnimalManagedBean {

	Animal animal;
	User user;
	IAnimalRepository animalRepository;
	IUserRepository userRepository;

	public AnimalManagedBean() {
		animal = new Animal();
		user = new User();
		animalRepository = new AnimalRepository();
		userRepository = new UserRepository();
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	// TODO userID yetkilendirme işlemi yapılınca sessiondan çekilecek
	public String save(AnimalManagedBean amb, int userID) {
		user = userRepository.findUserById(userID);
		amb.getAnimal().setUser(user);
		List<Animal> animals = user.getAnimals();
		animals.add(amb.getAnimal());
		user.setAnimals(animals);
		userRepository.updateUser(user);
		return "/secured/home?faces-redirect=true";
	}

	public String update(int id) {
		animal = animalRepository.findAnimalById(id);
		return "/secured/editAnimal?faces-redirect=true";
	}

	public String update(AnimalManagedBean amb) {
		animalRepository.updateAnimal(amb.getAnimal());
		return "/secured/home?faces-redirect=true";
	}

	public String delete(int id) {
		animalRepository.deleteAnimal(id);
		return "/secured/home?faces-redirect=true";
	}
}
