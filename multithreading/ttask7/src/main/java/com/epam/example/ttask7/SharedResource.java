package com.epam.example.ttask7;

public class SharedResource {
	private int resource;
	
	public SharedResource() {
		resource = 10;
	}
	
	public synchronized int increaseAndGet() {
		if (resource < 10) {
			resource++;
		}
		return resource;
	}
	
	public synchronized int decreaseAndGet() {
		if (resource > 5) {
			resource--;
		}
		return resource;
	}

}
