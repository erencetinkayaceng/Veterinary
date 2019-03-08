package com.cruz.dao;

import java.util.List;

import com.cruz.model.Animal;

public interface IAnimalRepository {
	Animal saveAnimal(Animal animal);

	void deleteAnimal(int id);

	Animal updateAnimal(Animal animal);

	Animal findAnimalById(int id);

	List<Animal> findAllAnimalByName(String name);
}
