package com.epam.example.ttask6;

import java.util.Random;

public class Producer implements Runnable {
	private MessageBus mb;
	private Random rand;
	
	public Producer(MessageBus mb) {
		this.mb = mb;
		rand = new Random(System.currentTimeMillis());
	}

	@Override
	public void run() {
		while(true) {
			try {
				int value = rand.nextInt();
				mb.put(value);
				System.out.println("Producer has produced " + value);
				Thread.sleep(200);
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
	}

}
