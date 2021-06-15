package com.dusanweb.sna.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping
	public Iterable<Person> getAllPersons(){
		log.trace("200 (OK)"); 
		return personService.findAllPersons();
	}

//	@GetMapping("/addListBdd")
//	public Iterable<Person> saveAllPersons(){
//		return personService.saveAllPersons();
//	}
	
}
