package com.epam.example.ttask7;

public class Producer implements Runnable {
	private SharedResource sr;
	
	public Producer(SharedResource sr) {
		this.sr = sr;
	}

	@Override
	public void run() {
		while(true) {
			try {
				int value = sr.increaseAndGet();
				System.out.println("Producer can increase value to 10. Now it is " + value);
				Thread.sleep((int)(Math.random() * 900  + 100));
			} catch (InterruptedException e) {
			}
		}
	}

}
