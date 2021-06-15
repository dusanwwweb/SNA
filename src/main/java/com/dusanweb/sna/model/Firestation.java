package com.dusanweb.sna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "firestation")
@Getter
@Setter
@NoArgsConstructor
@ToString 
public class Firestation {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "address")
    private String address;
	
	@Column(name = "station")
    private int station;

	//Constructor method without an ID field
	public Firestation(String address, int station) {
		this.address = address;
		this.station = station;
	}
	
}
