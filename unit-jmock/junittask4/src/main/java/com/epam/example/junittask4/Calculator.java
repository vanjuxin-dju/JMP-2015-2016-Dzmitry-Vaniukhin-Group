package com.epam.example.junittask4;

public class Calculator {
	public double add(double arg1, double arg2) {
		return arg1 + arg2;
	}
	
	public double substract(double arg1, double arg2) {
		return arg1 - arg2;
	}
	
	public double multiply(double arg1, double arg2) {
		return arg1 * arg2;
	}
	
	public double divide(double arg1, double arg2) {
		if (arg2 == 0.0)
			throw new IllegalArgumentException("Division by zero!");
		return arg1 / arg2;
	}
	
	public double power(double arg1, double arg2) {
		return Math.pow(arg1, arg2);
	}
	
	public double squareRoot(double arg) {
		if (arg < 0.0) 
			throw new IllegalArgumentException("Square root from negative value!");
		return Math.sqrt(arg);
	}
	
	public boolean isPrime(int arg) {
		if (arg <= 0)
			throw new IllegalArgumentException("Negative or zero argument cannot be checked!");
		if (arg == 1)
			return false;
		int half = arg / 2;
		for (int i = 2; i < half; i++) {
			if (arg % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public int[] fibonacciSequence(int count) {
		if (count <= 0) {
			throw new IllegalArgumentException("Fibonacci sequence from negative or zero count of values!");
		}
		int[] sequence = new int[count];
		sequence[0] = 0;
		if (count > 1) {
			sequence[1] = 1;
		}
		for (int i = 2; i < count; i++) {
			sequence[i] = sequence[i - 1] + sequence[i - 2];
		}
		return sequence;
	}
}
