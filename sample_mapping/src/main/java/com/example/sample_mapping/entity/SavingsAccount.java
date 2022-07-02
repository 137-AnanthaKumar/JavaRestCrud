package com.example.sample_mapping.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class SavingsAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
	private int accountId;
	@Column(unique = true)
	private int accountNumber;
	private Double accountBalance;
	private Long cifNo;
	private String branchName;
	private Long ifscCode;
	private byte isNetBankingActive=0;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "savingsAccountId")
	private List<SavingsTransaction> savingsTransactionList=new ArrayList<SavingsTransaction>();
	
	
}
