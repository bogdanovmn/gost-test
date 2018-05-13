package com.github.bogdanovmn.gosttest.words;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class Text {
	private final String sourceFileName;
	private Map<String, Integer> statistic = null;

	Text(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}

	void printStatistic() {
		prepare();
		statistic.keySet().stream()
			.sorted(
				Comparator.comparing((String word) -> statistic.get(word)).reversed()
			)
			.forEach(word ->
				System.out.println(
					String.format(
						"[%5d] %s", statistic.get(word), word
					)
				)
			);
	}

	private void prepare() {
		if (statistic == null) {
			statistic = new HashMap<>();
			try (Stream<String> lines = Files.lines(Paths.get(sourceFileName))) {
				lines.forEach(
					line -> {
						String[] words = line.split("\\W");
						Arrays.stream(words)
							.filter(word -> !word.equals(""))
							.forEach(
								word -> statistic.compute(
									word,
									(k, v) -> v == null
										? 1
										: v + 1
								)
						);
					}
				);

			}
			catch (IOException e) {
				throw new RuntimeException(
					String.format(
						"Source file '%s' read error", sourceFileName
					), e
				);
			}
		}
	}
}
