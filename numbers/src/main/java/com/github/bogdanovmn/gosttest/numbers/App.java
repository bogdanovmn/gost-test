package com.github.bogdanovmn.gosttest.numbers;

import com.github.bogdanovmn.cmdlineapp.CmdLineAppBuilder;

public class App {
	public static void main(String[] args) throws Exception {
		new CmdLineAppBuilder(args)
			.withJarName("numbers")
			.withDescription("1..100 numbers mapping")
			.withEntryPoint(
				cmdLine -> {
					for (int i = 1; i <= 100; i++) {
						if (i % 7 == 0 && i % 2 == 0) {
							System.out.println("TwoSeven");
						}
						else if (i % 2 == 0) {
							System.out.println("Two");
						}
						else if (i % 7 == 0) {
							System.out.println("Seven");
						}
						else {
							System.out.println(i);
						}
					}
				}
			).build().run();
	}
}
