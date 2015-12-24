package com.epam.example.task2;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class App {
	private static Logger LOGGER = LogManager.getLogger(App.class);
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void initList(List list) {
		list.add("one");
		list.add("two");
		list.add("three");
	}
	
	@SuppressWarnings("rawtypes")
	private static void printList(List list) {
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		LOGGER.addAppender(new ConsoleAppender(new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN)));
		LOGGER.setLevel(Level.ALL);
		
		List list = new ArrayList();
		initList(list);
		printList(list);
		
		LOGGER.info("Loading file iterator-example-0.0.1-SNAPSHOT.jar...");
		URLClassLoader clsLoader = URLClassLoader.newInstance(new URL[] { new URL("file:/D://iterator-example-0.0.1-SNAPSHOT.jar")});
		LOGGER.info("Loading complete.");
		
		LOGGER.info("Loading class com.epam.example.iteratorexample.MyArrayList...");
		Class cls = clsLoader.loadClass("com.epam.example.iteratorexample.MyArrayList");
		LOGGER.info("Changing List from ArrayList to com.epam.example.iteratorexample.MyArrayList...");
		list = (List) cls.newInstance();
		initList(list);
		printList(list);
	}

}
