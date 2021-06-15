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

import com.dusanweb.sna.model.MedicalRecord;
import com.dusanweb.sna.service.MedicalRecordService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/medicalRecord")
public class MedicaRecordController {

	private MedicalRecordService medicalRecordService;

	@Autowired
	public MedicaRecordController(MedicalRecordService medicalRecordService) {
		this.medicalRecordService = medicalRecordService;
	}
	
//	@GetMapping("/addListBdd")
//	public Iterable<MedicalRecord> saveAllMedicaRecords(){
//		log.trace("200 (OK)"); 
//		return medicalRecordService.saveAllMedicalRecords();
//	}
	
	//READ
	@GetMapping
	public Iterable<MedicalRecord> getAllMedicalRecords(){
		log.trace("200 (OK)");
		return medicalRecordService.findAllMedicalRecords();
	}
	
	//CREATE
	@PostMapping
	public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		log.trace("201 (Created)"); 
		return medicalRecordService.createMedicalRecord(medicalRecord);
	}
	
	//UPDATE
	@PutMapping("/{id}")
	public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord, @PathVariable Long id) {
		MedicalRecord existingMedicalRecord = medicalRecordService.findOneMedicalRecord(id);
		
		existingMedicalRecord.setFirstName(medicalRecord.getFirstName());
		existingMedicalRecord.setLastName(medicalRecord.getLastName());
		existingMedicalRecord.setBirthdate(medicalRecord.getBirthdate());
		existingMedicalRecord.setMedications(medicalRecord.getMedications());
		existingMedicalRecord.setAllergies(medicalRecord.getAllergies());
		
		final MedicalRecord updatedMedicalRecord = medicalRecordService.save(existingMedicalRecord);
		return updatedMedicalRecord;
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public void deleteMedicalRecord(@PathVariable Long id) {
		log.trace("200 (OK)"); 
		medicalRecordService.deleteMedicalRecord(id);
	}
	
}
