package com.cruz.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cruz.dao.IAnimalRepository;
import com.cruz.dao.IUserRepository;
import com.cruz.dao.impl.AnimalRepository;
import com.cruz.dao.impl.UserRepository;
import com.cruz.model.Animal;
import com.cruz.model.User;

@ManagedBean
@ViewScoped
public class SearchManagedBean {
	private String searchWord;
	IUserRepository userRepository;
	IAnimalRepository animalRepository;
	private List<User> users;
	private List<Animal> animals;

	public SearchManagedBean() {
		userRepository = new UserRepository();
		animalRepository = new AnimalRepository();
		users = new ArrayList<User>();
		animals = new ArrayList<Animal>();
		searchWord = "";
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public void getUserList(SearchManagedBean smb) {
		users = userRepository.findAllUserByName(smb.getSearchWord());
	}

	public void getAnimalList(SearchManagedBean smb) {
		animals = animalRepository.findAllAnimalByName(smb.getSearchWord());
	}
}
