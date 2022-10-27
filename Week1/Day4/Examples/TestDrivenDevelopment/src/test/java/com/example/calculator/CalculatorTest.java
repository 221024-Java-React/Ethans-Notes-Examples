package com.example.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	/* Red green testing
	 * Write a test it will fail
	 * Refactor, run the test again it will pass
	 * Write a new more specific test, run the test it will fail
	 * So on and so forth
	 */
	
	private static Calculator calc;
	
	@BeforeClass
	public static void setUpNewCalculator() {
		System.out.println("This method would run once before any of the tests");
		calc = new Calculator();
	}
	
	@Before
	public void setupBeforeEachTest() {
		System.out.println("This will run before each test");
	}
	
	@After
	public void tearDownAfterEachTest() {
		System.out.println("This will run after each test");
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("This will run after the entire test suite");
	}
	
	@Test
	public void testAddition1() {
		//We expect this to 2
		int actual = calc.add(1, 1);
		
		//Lets test our expected output
		//Message, expected output, actual
		assertEquals("1 + 1 = 2", 2, actual);
	}
	
	@Test
	public void testAddition2() {
		int actual = calc.add(2, 1);
		
		assertEquals("2 + 1 = 3", 3, actual);
	}
	
	/* We can test for exceptions in Junit */
	//If this exception does not occur, your test will fail
	@Test(expected = ArithmeticException.class)
	public void testDivideByZero() {
		int test = calc.divide(1, 0);
	}

}
