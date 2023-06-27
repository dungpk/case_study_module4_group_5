package com.codegym.haichanbank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Accounts {

	@Column(name = "customer_id")
	private int customerId;

	@Id
	@Column(name="account_number")
	private long accountNumber;

	@Column(name="account_type")
	private String accountType;

	@Column(name = "branch_address")
	private String branchAddress;

	@Column(name = "create_dt")
	private String createDt;
	
	@Column(name = "account_is_active")
	private boolean isActive;
	
}