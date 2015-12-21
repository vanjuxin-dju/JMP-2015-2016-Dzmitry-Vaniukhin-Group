package com.epam.example.facade;

import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws SQLException {
		DBConnection conn = DBConnection.getInstance();
		for (Person person: conn.getPeople()) {
			System.out.println(person);
		}
	}

}
