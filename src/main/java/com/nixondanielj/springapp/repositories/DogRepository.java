package com.nixondanielj.springapp.repositories;

import java.util.List;

import com.nixondanielj.springapp.models.Dog;

public interface DogRepository {
	List<Dog> getAll();
	Dog getById(int id);
	List<Dog> getByName(String name);
	int add(Dog dog);
	void update(Dog dog);
	void delete(Dog dog);
	void delete(int id);
}
