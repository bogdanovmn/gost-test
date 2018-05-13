package com.github.bogdanovmn.gosttest.function;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FactorialTest {

	@Test
	public void toBigInteger() {
		assertEquals(
			new BigInteger("6"),
			new Factorial(
				new BigInteger("3")
			).toBigInteger()
		);
	}
}