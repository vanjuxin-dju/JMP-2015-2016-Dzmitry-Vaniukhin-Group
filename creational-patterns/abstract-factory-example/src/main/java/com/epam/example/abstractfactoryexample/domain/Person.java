package com.epam.example.abstractfactoryexample.domain;

import java.sql.Date;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public interface Person {
	Integer getIdPerson();

	void setIdPerson(Integer idPerson);

	String getName();

	void setName(String name);

	String getSurname();

	void setSurname(String surname);

	Date getBirthday();

	void setBirthday(Date birthday);

	String getHomeTown();

	void setHomeTown(String homeTown);

}
