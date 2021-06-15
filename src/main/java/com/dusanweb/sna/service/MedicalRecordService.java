package com.dusanweb.sna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dusanweb.sna.model.MedicalRecord;
import com.dusanweb.sna.repository.MedicalRecordRepository;
import com.dusanweb.sna.utils.DataParserJson;

@Service
public class MedicalRecordService {

	private MedicalRecordRepository medicalRecordRepository;

	@Autowired
	public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
		this.medicalRecordRepository = medicalRecordRepository;
	}
	
	@Autowired
	private DataParserJson data;
	
	public Iterable<MedicalRecord> saveAllMedicalRecords() {
		//inserer les donnees du fichier json en BDD
		List<MedicalRecord> medicalRecord = this.data.readJson().getMedicalRecords();
		return medicalRecordRepository.saveAll(medicalRecord);	
	}
	
	public Iterable<MedicalRecord> findAllMedicalRecords(){
		return medicalRecordRepository.findAll();
	}
	
}
