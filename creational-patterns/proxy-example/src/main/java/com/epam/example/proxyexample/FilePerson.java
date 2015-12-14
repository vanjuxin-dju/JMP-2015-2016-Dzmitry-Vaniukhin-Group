package com.epam.example.proxyexample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class FilePerson implements Person {
	private static final String PATH = "d:\\people.txt";
	
	private String personData;

	@Override
	public String readPerson(String name) {
		if (personData == null) {
			Scanner sc;
			try {
				sc = new Scanner(new File(PATH));
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					if (line.split("\t")[0].equals(name)) {
						personData = line;
						break;
					}
				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return personData;
	}

}
