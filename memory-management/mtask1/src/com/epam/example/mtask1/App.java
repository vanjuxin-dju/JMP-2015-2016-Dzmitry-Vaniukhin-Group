package com.epam.example.mtask1;

public class App {
	public static void addTwo(Value value) {
		System.out.println("Value before: " + value.getValue());
		value.setValue(value.getValue() + 2);
		System.out.println("Value after: " + value.getValue());
	}
	
	public static void main(String[] args) {
		Value value = new Value();
		value.setValue(10);
		System.out.println("Value in main before: " + value.getValue());
		addTwo(value);
		System.out.println("Value in main after: " + value.getValue());
	}

}
