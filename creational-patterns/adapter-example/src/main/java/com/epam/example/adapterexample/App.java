package com.epam.example.adapterexample;

public class App {

	public static void main(String[] args) {
		ListWrapper<String> givenStack = new ListWrapper<>();
		givenStack.push("o");
		givenStack.push("l");
		givenStack.push("l");
		givenStack.push("e");
		givenStack.push("H");
		
		try {
			System.out.println(givenStack.pop());
			System.out.println(givenStack.pop());
			System.out.println(givenStack.pop());
			System.out.println(givenStack.pop());
			System.out.println(givenStack.pop());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
