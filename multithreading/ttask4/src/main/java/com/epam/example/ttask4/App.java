package com.epam.example.ttask4;

import org.apache.log4j.Logger;

public class App {
	static Logger LOG = Logger.getLogger(App.class);
	public static void main(String[] args) {
		Runnable bmw = new Car("BMW", 100);
		Runnable bentley = new Car("Bentley", 120);
		Runnable mersedes = new Car("Mersedes", 110);
		
		Thread thread1 = new Thread(bmw);
		Thread thread2 = new Thread(bentley);
		Thread thread3 = new Thread(mersedes);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		while (true) {
			if (thread1.getState() == Thread.State.TERMINATED) {
				LOG.info("BMW is winner");
				break;
			} else if (thread2.getState() == Thread.State.TERMINATED) {
				LOG.info("Bentley is winner");
				break;
			} else if (thread3.getState() == Thread.State.TERMINATED) {
				LOG.info("Mersedes is winner");
				break;
			}
		}
		
	}

}
