package com.dusanweb.sna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping
	public Iterable<MedicalRecord> getAllMedicalRecords(){
		log.trace("200 (OK)");
		return medicalRecordService.findAllMedicalRecords();
	}
	
}
