package com.epam.example.facadeexample;

import java.util.List;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class Facade {
	private PersonLoader personLoader;
	private List<Person> people;
	
	public Facade() {
		personLoader = new PersonLoader();
		people = personLoader.loadPeople();
	}
	
	public void compareIq() {
		Person p1 = people.get(0);
		Person p2 = people.get(1);
		if (p1.getIq() > p2.getIq())
			System.out.println(p1.getName() + " is smarter than " + p2.getName());
		else if (p1.getIq() < p2.getIq())
			System.out.println(p2.getName() + " is smarter than " + p1.getName());
		else
			System.out.println("IQs of " + p1.getName() + " and " + p2.getName() + " are equal");
	}
	
	public void moveIq() throws Exception {
		int amount = 5;
		people.get(2).setIq(people.get(2).getIq() - amount);
		people.get(3).setIq(people.get(3).getIq() + amount);
		personLoader.storePeople(people);
		System.out.println("From now " + people.get(2).getName() + " has moved " + amount + " points to " + people.get(3).getName());
	}
	
	public void incrementIq() throws Exception {
		int amount = 5;
		people.get(2).setIq(people.get(2).getIq() + amount);
		personLoader.storePeople(people);
		System.out.println(people.get(2).getName() + " has become " + amount + " points smarter");
	}
}
