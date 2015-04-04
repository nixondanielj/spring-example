package com.nixondanielj.springapp.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nixondanielj.springapp.models.Dog;

@Repository
public class InMemoryDogRepository implements DogRepository {
	
	public InMemoryDogRepository() {
		dogs = new ArrayList<Dog>();
	}
	
	private List<Dog> dogs;

	@Override
	public List<Dog> getAll() {
		return new ArrayList<Dog>(dogs);
	}

	@Override
	public Dog getById(int id) {
		for(Dog dog : dogs){
			if(dog.getId() == id){
				return dog;
			}
		}
		return null;
	}

	@Override
	public List<Dog> getByName(String name) {
		List<Dog> matches = new ArrayList<Dog>();
		for(Dog dog : dogs){
			if(dog.getName().toLowerCase().contains(name.toLowerCase())){
				matches.add(dog);
			}
		}
		return matches;
	}

	@Override
	public int add(Dog dog) {
		dogs.add(dog);
		dog.setId(dogs.size());
		return dog.getId();
	}

	@Override
	public void update(Dog dog) {
		delete(dog.getId());
		dogs.add(dog);
	}

	@Override
	public void delete(Dog dog) {
		delete(dog.getId());
	}

	@Override
	public void delete(int id) {
		dogs.remove(getById(id));
	}

}
