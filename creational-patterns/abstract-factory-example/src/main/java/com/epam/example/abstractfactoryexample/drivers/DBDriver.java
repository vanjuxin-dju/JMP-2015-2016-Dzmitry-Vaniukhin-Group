package com.epam.example.abstractfactoryexample.drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.example.abstractfactoryexample.domain.Person;
import com.epam.example.abstractfactoryexample.domain.impl.PersonImpl;

public class DBDriver {
	private static DBDriver INSTANCE;
	private static final String URL = "jdbc:ucanaccess://d:/Database1.accdb";
	
	private Connection connection;

	public static DBDriver getInstance() throws ClassNotFoundException, SQLException {
		if (INSTANCE == null) {
			INSTANCE = new DBDriver();
		}
		return INSTANCE;
	}
	
	private DBDriver() throws ClassNotFoundException, SQLException {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		
		connection = DriverManager.getConnection(URL, "", "");
	}
	
	public Person getPersonByName(String name) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM person WHERE name = ?");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			rs.next();
			Person person = new PersonImpl();
			person.setIdPerson(rs.getInt(1));
			person.setName(rs.getString(2));
			person.setSurname(rs.getString(3));
			person.setBirthday(rs.getDate(4));
			person.setHomeTown(rs.getString(5));
			return person;
		} else {
			return null;
		}
	}
	
	public List<Person> getPeople() throws SQLException {
		List<Person> people = new ArrayList<Person>();
		Statement statement = connection.createStatement();
		statement.execute("SELECT * FROM person");
		ResultSet rs = statement.getResultSet();
		if (rs != null) {
			while (rs.next()) {
				Person person = new PersonImpl();
				person.setIdPerson(rs.getInt(1));
				person.setName(rs.getString(2));
				person.setSurname(rs.getString(3));
				person.setBirthday(rs.getDate(4));
				person.setHomeTown(rs.getString(5));
				people.add(person);
				//System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDate(4) + "\t" + rs.getString(5));
			}
		}
		statement.close();
		return people;
	}
	
	public void insertPerson(Person person) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO person(name,surname,birthday,homeTown) VALUES (?,?,?,?)");
		ps.setString(1, person.getName());
		ps.setString(2, person.getSurname());
		ps.setDate(3, person.getBirthday());
		ps.setString(4, person.getHomeTown());
		ps.execute();
		ps.close();
	}
}
