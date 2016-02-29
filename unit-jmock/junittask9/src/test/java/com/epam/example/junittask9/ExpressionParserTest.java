package com.epam.example.junittask9;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExpressionParserTest {
	private static ExpressionParser ep;
	
	@BeforeClass
	public static void init() {
		ep = new ExpressionParser();
	}
	
	@Test
	public void testSimpleAdding() {
		Assert.assertEquals(5, ep.execute("3+2"), 0.00001);
	}
	
	@Test
	public void testSimpleSubstracting() {
		Assert.assertEquals(8, ep.execute("8.5-0.5"), 0.00001);
	}
	
	@Test
	public void testSimpleMultiplying() {
		Assert.assertEquals(40, ep.execute("8*5"), 0.00001);
		Assert.assertEquals(0, ep.execute("0*5"), 0.00001);
	}
	
	@Test
	public void testSimpleDivision() {
		Assert.assertEquals(3, ep.execute("9 / 3"), 0.00001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDivisionByZero() {
		ep.execute("9/0");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWrongInput() {
		ep.execute("blah-blah-blah");
	}

}
