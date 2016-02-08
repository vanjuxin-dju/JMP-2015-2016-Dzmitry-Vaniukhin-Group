package com.epam.example.ttask6;

public class App {

	public static void main(String[] args) {
		MessageBus mb = new MessageBus();
		Thread producer = new Thread(new Producer(mb));
		Thread cunsomer = new Thread(new Consumer(mb));
		
		producer.start();
		cunsomer.start();
	}

}
