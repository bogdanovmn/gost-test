package com.github.bogdanovmn.gosttest.function;

import java.math.BigInteger;

class Factorial {
	private final BigInteger n;
	private BigInteger result;

	Factorial(BigInteger n) {
		if (n.equals(BigInteger.ZERO)) {
			throw new IllegalStateException("Natural number expected");
		}
		this.n = n;
	}

	BigInteger toBigInteger() {
		return compute();
	}

	private BigInteger compute() {
		if (result == null) {
			result = BigInteger.ONE;

			for (BigInteger i = new BigInteger("2"); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
				result = result.multiply(i);
			}
		}
		return result;
	}
}
