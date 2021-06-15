package com.dusanweb.sna.utils;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dusanweb.sna.model.Firestation;
import com.dusanweb.sna.model.MedicalRecord;
import com.dusanweb.sna.model.Person;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@NoArgsConstructor
@ToString 
public class JsonWrapper {

    List<Person> persons;
    List<Firestation> firestations;
    List<MedicalRecord> medicalRecords;
    
    @JsonCreator
	public JsonWrapper(List<Person> persons, List<Firestation> firestations, @JsonProperty("medicalrecords") List<MedicalRecord> medicalRecords) {
		this.persons = persons;
		this.firestations = firestations;
		this.medicalRecords = medicalRecords;
	}
    
}
