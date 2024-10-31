package com.example.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

	private Calculator c;
	private float accuracy = (float) 1e-3;

	@BeforeEach
	void setUp() {
		c = new Calculator();
		assumeNotNull(c);
	}

	@AfterEach
	void tearDown() {
		c = null;
		assumeTrue(c == null);
	}

	@Test
	public void exceptionTestingBase() {
		try {
			c.division(7, 0);
		} catch (Exception e) {
			return;
		}
		fail("Attesa Divisione per zero");

	}

	@Test
	public void exceptionTesting() {
		Exception exception = assertThrows(Exception.class, () -> c.division(7, 0));
		assertEquals("Divisione per zero", exception.getMessage());
	}

	/*
	 * @Test(expected=Exception.class)
	 * public void exceptionTestingAnnotation() throws Exception{
	 * c.division(7, 0);
	 * }
	 */

}
