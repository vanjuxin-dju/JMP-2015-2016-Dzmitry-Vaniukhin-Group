package com.epam.example.ttask6;

public class MessageBus {
	private int content;
	private boolean generationAvaliable;
	
	public MessageBus() {
		generationAvaliable = true;
	}
	
	public synchronized void put(int value) {
		while (!generationAvaliable) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		content = value;
		generationAvaliable = false;
		notifyAll();
	}
	
	public synchronized int get() {
		while (generationAvaliable) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		generationAvaliable = true;
		notifyAll();
		return content;
	}

}
