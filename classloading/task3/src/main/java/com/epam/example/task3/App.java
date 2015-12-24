package com.epam.example.task3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InstantiationException {
		// semaphore can be:
		// * com.epam.example.task3.Semaphore
		// * com.epam.example.task3.SemaphoreOne
		// * com.epam.example.task3.SemaphoreTwo
		// * com.epam.example.task3.SemaphoreThree
		Scanner scanner = new Scanner(System.in);
		String semaphore = null;
		do {
			System.out.print("\nEnter class path (or just press Enter to exit): ");
			if (scanner.hasNextLine())
				semaphore = scanner.nextLine();
			if (semaphore != null && !semaphore.isEmpty()) {
				ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
				Class<?> semaphoreClass = classLoader.loadClass(semaphore);
				Object s = semaphoreClass.newInstance();
				Method lever = semaphoreClass.getMethod("lever");
				lever.invoke(s);
			}
		} while (semaphore != null && !semaphore.isEmpty());
		scanner.close();
	}

}
