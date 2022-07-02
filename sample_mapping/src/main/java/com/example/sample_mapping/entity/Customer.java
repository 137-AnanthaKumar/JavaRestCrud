package com.example.sample_mapping.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	@Column
	private String name;
	
	@Column(length=100)
	private String password;
	@Column(name="intpass")
	private String intpass;
	@Column(name="email",unique = true)
	private String email;
	@Column
	private String mobileNo;
	@JsonIgnoreProperties("customer")
	@OneToOne(mappedBy="customer",cascade=CascadeType.PERSIST,orphanRemoval = true)
	private SavingsAccount savingsAccount;
	

}
