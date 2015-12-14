package com.epam.example.decoratorexample;

import java.io.OutputStream;
import java.io.PrintWriter;

public class PersonOutputStream {
	private OutputStream outputStream;
	private PrintWriter printWriter;
	
	public PersonOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
		printWriter = new PrintWriter(this.outputStream);
	}
	
	public void writePerson(Person person) {
		String name = person.getName();
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		printWriter.println(name + "\t" + person.getAge());
	}
	
	public void close() {
		printWriter.close();
	}
}
