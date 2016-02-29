package com.epam.example.junittask4;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorNegativeTest {
private static Calculator calculator;
	
	@BeforeClass
	public static void init() {
		calculator = new Calculator();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDividingByZero() {
		Assert.assertEquals(4, calculator.divide(36, 0), 0.00001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSquareRootFromNegative() {
		Assert.assertEquals(32, calculator.squareRoot(-1024), 0.00001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIsPrimeNegative() {
		Assert.assertTrue(calculator.isPrime(-11));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIsPrimeZero() {
		Assert.assertFalse(calculator.isPrime(0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFibonacciSequenceOfZeroValues() {
		Assert.assertArrayEquals(new int[] {0}, calculator.fibonacciSequence(0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFibonacciSequenceOfNegativeCountOfValues() {
		Assert.assertArrayEquals(new int[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34}, calculator.fibonacciSequence(-10));
	}
}
