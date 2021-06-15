package com.dusanweb.sna.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dusanweb.sna.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

}
