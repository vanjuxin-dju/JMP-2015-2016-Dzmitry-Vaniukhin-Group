package com.epam.example.jpatask2.domain;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idClient")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany
	@JoinColumn(referencedColumnName = "idAccount")
	private Set<Account> accounts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
}
