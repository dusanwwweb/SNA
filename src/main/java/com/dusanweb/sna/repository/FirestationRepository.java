package com.dusanweb.sna.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dusanweb.sna.model.Firestation;

@Repository
public interface FirestationRepository extends CrudRepository<Firestation, Long>{

}
