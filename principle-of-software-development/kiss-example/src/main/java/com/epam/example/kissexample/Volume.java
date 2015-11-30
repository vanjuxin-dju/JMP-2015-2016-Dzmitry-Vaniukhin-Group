package com.epam.example.kissexample;

public class Volume {
	public static double ellipsoid(double a, double b, double c) {
		return 4 * Math.PI * a * b * c / 3.0;
	}
	
	public static double ball(double radius) {
		return 4 * Math.PI * Math.pow(radius, 3) / 3.0;
	}
	
	public static double parallelepiped(double a, double b, double c) {
		return a * b * c;
	}
	
	public static double parallelepiped(double a, double b, double c, double alpha, double beta, double gamma) {
		return parallelepiped(a, b, c) * Math.sqrt(1.0 + 2.0 * Math.cos(alpha) * Math.cos(beta) * Math.cos(gamma) 
				- Math.pow(Math.cos(alpha), 2) - Math.pow(Math.cos(beta), 2) - Math.pow(Math.cos(gamma), 2));
	}
	
	private Volume() {
	}
}
