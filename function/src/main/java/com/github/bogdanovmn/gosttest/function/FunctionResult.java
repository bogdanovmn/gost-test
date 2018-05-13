package com.github.bogdanovmn.gosttest.function;

import java.math.BigInteger;

class FunctionResult {
	private final BigInteger m;
	private final BigInteger r;

	FunctionResult(BigInteger m, BigInteger r) {
		this.m = m;
		this.r = r;
	}

	/*
		Функцию можно упростить, сокртив числитель и знаменатель
		Причем если r! > (m-r)!, то оптимальнее соркащать на r! и наоборот соответственно

		В случае когда m == r, предполагается деление на нуль
		Учитывая что в требованиях к функции есть условие  r <= m
		уточню требования для данного варианта, и допустим результатом уточнения
		будет "надо возвращать нуль"...
	 */
	BigInteger compute() {
		return m.equals(r)
			? BigInteger.ZERO
			: smartCompute();
	}

	private BigInteger smartCompute() {
		return m.subtract(r).compareTo(r) < 0
			? smartComputeRReduction()
			: smartComputeMRSubtractReduction();
	}

	private BigInteger smartComputeRReduction() {
		BigInteger n = m.subtract(r);
		Factorial nFactorial = new Factorial(n);

		BigInteger p = BigInteger.ONE;
		for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
			p = p.multiply(r.add(i));
		}
		return p.divide(nFactorial.toBigInteger());
	}

	private BigInteger smartComputeMRSubtractReduction() {
		BigInteger n = m.subtract(r);
		BigInteger k = m.subtract(n);
		Factorial rFactorial = new Factorial(r);

		BigInteger p = BigInteger.ONE;
		for (BigInteger i = BigInteger.ONE; i.compareTo(k) <= 0; i = i.add(BigInteger.ONE)) {
			p = p.multiply(n.add(i));
		}
		return p.divide(rFactorial.toBigInteger());
	}
}
