package com.epam.example.mtask7;

import javassist.CannotCompileException;
import javassist.ClassPool;

public class App {

	public static void main(String[] args) throws CannotCompileException {
		ClassPool cp = ClassPool.getDefault();
		Employee emp = new Employee(0);
		
		for (int i=0;;i++) {
			Class c = cp.makeClass("com.epam.example.examplespackage.NewClass" + i).toClass();
			System.out.println(c.toString());
		}

	}

}
