package com.github.bogdanovmn.gosttest.function;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FunctionResultTest {

	@Test
	public void compute() {
		assertEquals(
			"R equals M",
				BigInteger.ZERO,
				new FunctionResult(BigInteger.TEN, BigInteger.TEN).compute()
		);

		assertEquals(
			"R less than M",
				new BigInteger("21"),
				new FunctionResult(new BigInteger("7"), new BigInteger("2")).compute()
		);
	}
}
