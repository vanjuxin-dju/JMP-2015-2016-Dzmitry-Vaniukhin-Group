package com.epam.example.junittask4;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorPositiveTest {
	private static Calculator calculator;
	
	@BeforeClass
	public static void init() {
		calculator = new Calculator();
	}
	
	@Test
	public void testAdding() {
		Assert.assertEquals(5, calculator.add(2.5, 2.5), 0.00001);
		Assert.assertEquals(8, calculator.add(-4, 12), 0.00001);
	}
	
	@Test
	public void testSubstracting() {
		Assert.assertEquals(5, calculator.substract(8, 3), 0.00001);
		Assert.assertEquals(-1, calculator.substract(6, 7), 0.00001);
	}
	
	@Test
	public void testMultiplying() {
		Assert.assertEquals(36, calculator.multiply(4, 9), 0.00001);
		Assert.assertEquals(-25, calculator.multiply(5, -5), 0.00001);
		Assert.assertEquals(0, calculator.multiply(0, -5), 0.00001);
	}
	
	@Test
	public void testDividing() {
		Assert.assertEquals(4, calculator.divide(36, 9), 0.00001);
		Assert.assertEquals(-5, calculator.divide(25, -5), 0.00001);
		Assert.assertEquals(0, calculator.divide(0, -5), 0.00001);
	}
	
	@Test
	public void testPower() {
		Assert.assertEquals(512, calculator.power(2, 9), 0.00001);
	}
	
	@Test
	public void testSquareRoot() {
		Assert.assertEquals(32, calculator.squareRoot(1024), 0.00001);
	}
	
	@Test
	public void testIsPrime() {
		Assert.assertTrue(calculator.isPrime(11));
		Assert.assertFalse(calculator.isPrime(9));
		Assert.assertFalse(calculator.isPrime(1));
	}
	
	@Test
	public void testFibonacciSequence() {
		Assert.assertArrayEquals(new int[] {0}, calculator.fibonacciSequence(1));
		Assert.assertArrayEquals(new int[] {0, 1}, calculator.fibonacciSequence(2));
		Assert.assertArrayEquals(new int[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34}, calculator.fibonacciSequence(10));
	}
}
