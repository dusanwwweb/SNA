package com.dusanweb.sna.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "medical_record")
@Getter
@Setter
@NoArgsConstructor
@ToString 
public class MedicalRecord {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "first_name")
    private String firstName;
	
	@Column(name = "last_name")
    private String lastName;

    @JsonFormat(pattern="MM/dd/yyyy")
    @Column(name = "birthdate")
    private LocalDate birthdate;
    
	@ElementCollection
	private List<String> medications;
	
    @ElementCollection
	private List<String> allergies;

    //Constructor method without an ID field 
	public MedicalRecord(String firstName, String lastName, LocalDate birthdate, List<String> medications,
			List<String> allergies) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
	} 
    
}
