package com.dusanweb.sna.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dusanweb.sna.model.Person;
import com.dusanweb.sna.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/person")
public class PersonController {

	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
//	@GetMapping("/addListBdd")
//	public Iterable<Person> saveAllPersons(){
//		return personService.saveAllPersons();
//	}
	
	//READ
	@GetMapping
	public Iterable<Person> getAllPersons(){
		log.trace("200 (OK)"); 
		return personService.findAllPersons();
	}

	//CREATE
	@PostMapping
	public Person createPerson(@RequestBody Person person){
		log.trace("201 (Created)"); 
		return personService.createPerson(person);
	}
	
	//UPDATE
	@PutMapping("/{id}")
	public Person updatePerson(@RequestBody Person person, @PathVariable Long id) {
		Person existingPerson = personService.findOnePerson(id);
		
		existingPerson.setFirstName(person.getFirstName());
		existingPerson.setLastName(person.getLastName());
		existingPerson.setAddress(person.getAddress());
		existingPerson.setCity(person.getCity());
		existingPerson.setZip(person.getZip());
		existingPerson.setPhone(person.getPhone());
		existingPerson.setEmail(person.getEmail());
		
		final Person updatedPerson = personService.save(existingPerson);

		log.trace("200 (OK)"); 
		return updatedPerson;
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable Long id) {
		log.trace("200 (OK)"); 
		personService.deletePerson(id);
	}
}
