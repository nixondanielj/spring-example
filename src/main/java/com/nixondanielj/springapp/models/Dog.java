package com.nixondanielj.springapp.models;

public class Dog {

	private String name;
	private String breed;
	private int age;
	private boolean active;
	private int id;
	
	public Dog() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getId() {
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}

}
