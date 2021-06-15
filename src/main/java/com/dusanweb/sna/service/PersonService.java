package com.dusanweb.sna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dusanweb.sna.model.Person;
import com.dusanweb.sna.repository.PersonRepository;
import com.dusanweb.sna.utils.DataParserJson;

@Service
public class PersonService { 

	private PersonRepository personRepository;
	
	@Autowired
	private DataParserJson data;
	
	@Autowired	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public Iterable<Person> saveAllPersons() {
		//inserer les donnees du fichier json en BDD
		List<Person> person = this.data.readJson().getPersons();
		return personRepository.saveAll(person);
	}
	
	public Iterable<Person> findAllPersons(){
		return personRepository.findAll();
	}

	public Person findOnePerson(Long id) {
		return personRepository.findById(id).get();
	}
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}

	public Person save(Person person) {
		return personRepository.save(person);
	}
	
}
