package com.dusanweb.sna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dusanweb.sna.model.Firestation;
import com.dusanweb.sna.repository.FirestationRepository;


@Service
public class FirestationService {

	private FirestationRepository firestationRepository;
	
	@Autowired
	public FirestationService(FirestationRepository firestationRepository) {
		this.firestationRepository = firestationRepository;
	}

	public Iterable<Firestation> saveAllFirestations(List<Firestation> firestation) {	
		return firestationRepository.saveAll(firestation);
	}
	
	public Iterable<Firestation> findAllFirestations(){
		return firestationRepository.findAll();
	}
	
	public Firestation findOneFirestation(Long id) {
        return firestationRepository.findById(id).get();
    }

	public Firestation createFirestation(Firestation firestation) {
		return firestationRepository.save(firestation);
	}

	public void deleteFirestation(Long id) {
		firestationRepository.deleteById(id);
	}

	public Firestation save(Firestation firestation) {
		return firestationRepository.save(firestation);
	}

//	public Firestation updateFirestation(Long id) {
//		firestationRepository.findById(id);
//		return firestationRepository.save(entity)
//	}


}
