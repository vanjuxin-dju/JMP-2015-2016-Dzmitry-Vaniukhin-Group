package com.epam.example.mtask7;

public class Employee {

	private String company = "qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm";
	private String name = "qwertyuiopasdfghjklzxcvbnm";
	
	public Employee(int i) {
		company += i;
		name += i;
		new Employee(i + 1);
	}

}
