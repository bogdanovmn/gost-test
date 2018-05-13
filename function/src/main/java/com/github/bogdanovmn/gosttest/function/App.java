package com.github.bogdanovmn.gosttest.function;

import com.github.bogdanovmn.cmdlineapp.CmdLineAppBuilder;

import java.math.BigInteger;

public class App {
	public static void main(String[] args) throws Exception {
		new CmdLineAppBuilder(args)
			.withJarName("function")
			.withDescription("Compute function f(m, r) = m!/r!(m - r)!, where r <= m and r, m is natural numbers")
			.withArg("m", "natural variable 'm'")
			.withArg("r", "natural variable 'r'")
			.withEntryPoint(
				cmdLine -> {
					BigInteger m = new BigInteger(cmdLine.getOptionValue("m"));
					BigInteger r = new BigInteger(cmdLine.getOptionValue("r"));

					if (m.compareTo(r) < 0) {
						throw new RuntimeException("M should not be less than R");
					}

					System.out.println(
						String.format(
							"Result = %s",
								new FunctionResult(m, r).compute()
						)
					);
				}
			).build().run();
	}
}
