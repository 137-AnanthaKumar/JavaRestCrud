package com.mapping.concept.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table
public class PersonAddress {

	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int adress_Id;
	  
	  private String home_No;

	  private String city;
	  
	  
	
	  public PersonAddress() {}
	public PersonAddress( String home_No, String city) {
		super();
	
		this.home_No = home_No;
		this.city = city;
	}
}
