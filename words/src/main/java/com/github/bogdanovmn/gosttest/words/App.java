package com.github.bogdanovmn.gosttest.words;

import com.github.bogdanovmn.cmdlineapp.CmdLineAppBuilder;

public class App {
	public static void main(String[] args) throws Exception {
		new CmdLineAppBuilder(args)
			.withJarName("words")
			.withDescription("parse input text from source file and print words statistic")
			.withArg("source", "Source file name")
			.withEntryPoint(
				cmdLine -> {
					Text text = new Text(
						cmdLine.getOptionValue("s")
					);

					text.printStatistic();
				}
			).build().run();
	}
}
