/**
 * 
 */
package com.epam.example.proxyexample;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class ProxyPerson implements Person {
	private Map<String, String> cache;

	public ProxyPerson() {
		cache = new HashMap<>();
	}

	@Override
	public String readPerson(String name) {
		String personData = null;
		if (!cache.keySet().contains(name)) {
			System.out.println("Getting " + name + " from file...");
			personData = new FilePerson().readPerson(name);
			cache.put(name, personData);
		} else {
			System.out.println("Getting " + name + " from cache...");
			personData = cache.get(name);
		}

		return personData;
	}

}
