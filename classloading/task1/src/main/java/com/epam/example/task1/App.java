package com.epam.example.task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		LOGGER.addAppender(new ConsoleAppender(new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN)));
		LOGGER.setLevel(Level.ALL);
		
		LOGGER.info("Loading file iterator-example-0.0.1-SNAPSHOT.jar...");
		URLClassLoader clsLoader = URLClassLoader.newInstance(new URL[] { new URL("file:/D://iterator-example-0.0.1-SNAPSHOT.jar")});
		LOGGER.info("Loading complete.");
		
		LOGGER.info("Loading class com.epam.example.iteratorexample.App...");
		Class cls = clsLoader.loadClass("com.epam.example.iteratorexample.App");
		LOGGER.info("Loading method main(String[] args)...");
		Method method = cls.getMethod("main", String[].class);
		LOGGER.info("Loading complete.");
		
		LOGGER.info("Executing...");
		String[] params = new String[2];
		method.invoke(null, (Object)params);
		LOGGER.info("Complete");
	}

}
