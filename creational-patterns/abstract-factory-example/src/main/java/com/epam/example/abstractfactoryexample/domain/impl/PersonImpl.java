package com.epam.example.abstractfactoryexample.domain.impl;

import java.sql.Date;

import com.epam.example.abstractfactoryexample.domain.Person;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class PersonImpl implements Person {
	private Integer idPerson;
	private String name;
	private String surname;
	private Date birthday;
	private String homeTown;

	public Integer getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	@Override
	public String toString() {
		return this.name + "\t" + this.surname + "\t" + this.birthday + "\t" + this.homeTown;
	}

}
