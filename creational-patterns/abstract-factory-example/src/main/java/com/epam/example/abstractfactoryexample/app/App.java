package com.epam.example.abstractfactoryexample.app;

import java.sql.Date;
import java.util.Calendar;

import com.epam.example.abstractfactoryexample.domain.Person;
import com.epam.example.abstractfactoryexample.domain.impl.PersonImpl;
import com.epam.example.abstractfactoryexample.factory.PersonFactory;
import com.epam.example.abstractfactoryexample.factory.impl.DBPersonFactory;
import com.epam.example.abstractfactoryexample.factory.impl.FilePersonFactory;

public class App {
	public static void main(String[] args) throws Exception {
		//PersonFactory pf = new DBPersonFactory();
		PersonFactory pf = new FilePersonFactory();
		/*for (Person person: pf.readPeople()) {
			System.out.println(person);
		}
		
		System.out.println(pf.readPerson("Andrey"));
		*/
		Calendar cal = Calendar.getInstance();
		cal.set(1994, 1, 1);
		Person newPerson = new PersonImpl();
		newPerson.setName("Vasili");
		newPerson.setSurname("Andriukhin");
		newPerson.setBirthday(new Date(cal.getTimeInMillis()));
		newPerson.setHomeTown("Skidel");
		pf.writePerson(newPerson);
	}

}
