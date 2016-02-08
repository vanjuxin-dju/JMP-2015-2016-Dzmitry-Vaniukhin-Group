package com.epam.example.ttask8;

public class App {
	private static int visIndex = 0;
	private static String[] visViews = { "\b\b\b---", "\b\b\b\\\\\\", "\b\b\b|||", "\b\b\b///" };
	
	public static void main(String[] args) throws InterruptedException {
		String path = args[0];
		Thread folderCalc = new Thread(new FolderCalculator(path));
		folderCalc.start();
		System.out.println("Path: " + path);
		
		System.out.print("   ");
		while(folderCalc.isAlive()) {
			System.out.print(nextVisualization());
			Thread.currentThread().sleep(200);
		}
		//folderCalc.join();
	}
	
	private static String nextVisualization() {
		visIndex %= 4;
		return visViews[visIndex++];
	}

}
