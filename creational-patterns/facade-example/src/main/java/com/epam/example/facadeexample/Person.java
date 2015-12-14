/**
 * 
 */
package com.epam.example.facadeexample;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class Person {
	private int iq;
	private String name;
	private int age;
	
	public Person(String name, int age, int iq) {
		this.name = name;
		this.age = age;
		this.iq = iq;
	}

	public int getIq() {
		return iq;
	}

	public void setIq(int iq) {
		this.iq = iq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
