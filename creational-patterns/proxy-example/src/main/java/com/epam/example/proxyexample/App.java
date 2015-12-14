package com.epam.example.proxyexample;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class App {

	public static void main(String[] args) {
		ProxyPerson proxy = new ProxyPerson();
		System.out.println(proxy.readPerson("dmitry"));
		System.out.println(proxy.readPerson("dmitry"));
		System.out.println(proxy.readPerson("andrey"));
		System.out.println(proxy.readPerson("pyotr"));
		System.out.println(proxy.readPerson("pyotr"));
		System.out.println(proxy.readPerson("pyotr"));
		System.out.println(proxy.readPerson("pyotr"));
		System.out.println(proxy.readPerson("pavel"));

	}

}
