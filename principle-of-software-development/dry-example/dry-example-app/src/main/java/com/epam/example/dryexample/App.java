package com.epam.example.dryexample;

import com.epam.example.dryexample.core.SuperPrint;
import com.epam.example.dryexample.core.impl.SuperPrintImpl;

public class App {

	public static void main(String[] args) {
		SuperPrint superPrint = new SuperPrintImpl();
		System.out.println(superPrint.print());
		System.out.println(superPrint.print("Dzmitry"));
	}

}
