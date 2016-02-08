package com.epam.example.ttask7;

public class Consumer implements Runnable {
	private SharedResource sr;

	public Consumer(SharedResource sr) {
		this.sr = sr;
	}

	@Override
	public void run() {
		while(true) {
			try {
				int value = sr.decreaseAndGet();
				System.out.println("Consumer can decrease value to 5. Now it is " + value);
				Thread.sleep((int)(Math.random() * 900  + 100));
			} catch (InterruptedException e) {
			}
		}
	}

}
