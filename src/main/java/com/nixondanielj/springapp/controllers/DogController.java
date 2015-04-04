package com.nixondanielj.springapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nixondanielj.springapp.models.Dog;
import com.nixondanielj.springapp.repositories.DogRepository;

@Controller
public class DogController {

	private DogRepository dogRepo;
	
	private String[] breeds = { "Rottweiler", "Husky", "Chihuaua", "Poodle" };
	
	@Autowired
	public DogController(DogRepository dogRepo) {
		this.dogRepo = dogRepo;
	}
	
	@RequestMapping(value="/dogs", method=RequestMethod.GET)
	public String index(@RequestParam(value="search", required = false) String search, Model model){
		List<Dog> dogs;
		if(search != null){
			dogs = dogRepo.getByName(search);
		} else {
			dogs = dogRepo.getAll();
		}
		if(dogs.size() == 0){
			model.addAttribute("message", "No dogs available. Please create some.");
		} else {
			model.addAttribute("dogs", dogs);
		}
		return "dog.index";
	}
	
	@RequestMapping(value="/dogs/add", method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("breeds", breeds);
		model.addAttribute("dog", new Dog());
		return "dog.add";
	}
	
	@RequestMapping(value="/dogs/add", method=RequestMethod.POST)
	public String add(Dog dog){
		dogRepo.add(dog);
		return "redirect:/dogs";
	}
	
	@RequestMapping(value="/dogs/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable int id, Model model){
		Dog dog = dogRepo.getById(id);
		model.addAttribute("dog", dog);
		model.addAttribute("breeds", breeds);
		return "dog.edit";
	}
	
	@RequestMapping(value="/dogs/edit/{id}", method=RequestMethod.POST)
	public String edit(@PathVariable int id, Dog dog){
		dogRepo.update(dog);
		return "redirect:/dogs";
	}
	
	@RequestMapping(value="/dogs/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		dogRepo.delete(id);
		return "redirect:/dogs";
	}
}
