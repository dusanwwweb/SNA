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

import com.dusanweb.sna.model.Firestation;
import com.dusanweb.sna.service.FirestationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/firestation")
public class FirestationController {

	private FirestationService firestationService;

	@Autowired
	public FirestationController(FirestationService firestationService) {
		this.firestationService = firestationService;
	}
	
	//READ
	@GetMapping
	public Iterable<Firestation> getAllFirestations(){
		log.trace("200 (OK)"); 	
		return firestationService.findAllFirestations();
	}
	
	//CREATE
	@PostMapping
	public Firestation createFirestation(@RequestBody Firestation firestation){
		log.trace("201 (Created)"); 
		return firestationService.createFirestation(firestation);
	}
	
	//UPDATE
	@PutMapping("/{id}")
	public Firestation updateFirestation(@RequestBody Firestation firestation, @PathVariable Long id) {
		Firestation existingFirestation = firestationService.findOneFirestation(id);
		
		existingFirestation.setAddress(firestation.getAddress());
		existingFirestation.setStation(firestation.getStation());	
		
		final Firestation updatedFirestation = firestationService.save(existingFirestation);

		log.trace("200 (OK)"); 
		return updatedFirestation;
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public void deleteFirestation(@PathVariable Long id) {
		log.trace("200 (OK)"); 
		firestationService.deleteFirestation(id);
	}
	
}