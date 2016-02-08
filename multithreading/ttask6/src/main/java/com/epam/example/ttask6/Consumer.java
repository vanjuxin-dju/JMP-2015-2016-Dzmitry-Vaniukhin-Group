package com.epam.example.ttask6;

public class Consumer implements Runnable {
	private MessageBus mb;
	
	public Consumer(MessageBus mb) {
		this.mb = mb;
	}

	@Override
	public void run() {
		while(true) {
			try {
				int value = mb.get();
				System.out.println("Consumer has consumed " + value);
				Thread.sleep(200);
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
	}

}
