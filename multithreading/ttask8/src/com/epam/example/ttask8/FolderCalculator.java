package com.epam.example.ttask8;

import java.io.File;

public class FolderCalculator implements Runnable {
	private String path;
	private long size;
	private long filesCount;
	private long foldersCount;
	
	public FolderCalculator(String path) {
		this.path = path;
		size = 0; filesCount = 0; foldersCount = 0;
	}

	@Override
	public void run() {
		listFiles(path);
		System.out.println("\n\n\n\nSize: " + size + ", files: " + filesCount + ", folders: " + foldersCount);
	}

	private void listFiles(String directoryName) {
		File directory = new File(directoryName);
		
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isFile()) {
				filesCount++;
				size += file.length();
			} else if (file.isDirectory()) {
				foldersCount++;
				listFiles(file.getAbsolutePath());
			}
		}
	}
}
