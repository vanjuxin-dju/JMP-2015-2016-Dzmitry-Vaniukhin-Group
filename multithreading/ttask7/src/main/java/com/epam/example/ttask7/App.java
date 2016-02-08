package com.epam.example.ttask7;

public class App {

	public static void main(String[] args) {
		SharedResource sr = new SharedResource();
		Thread producer = new Thread(new Producer(sr));
		Thread consumer = new Thread(new Consumer(sr));
		
		producer.start();
		consumer.start();
	}

}
