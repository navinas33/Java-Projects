package strings;

/*
(?i)     # Mode: case-insensitive
\b       # Match the start of a word
([a-z]+) # Match one ASCII "word", capture it in group 1
\b       # Match the end of a word
(?:      # Start of non-capturing group:
 \s+     # Match at least one whitespace character
 \1      # Match the same word as captured before (case-insensitively)
 \b      # and make sure it ends there.
)+       # Repeat that as often as possible
*/


import java.util.Scanner;
import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;

public class DuplicateWord {
	public static void main(String[] args) {

		String input = "why Do do it have have may duplicate words words in the the Here here?";
		String originalText = input;
		String output = "";
		Pattern p = Pattern.compile("\\b(\\w+)\\b\\s+\\b\\1\\b", Pattern.MULTILINE + Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(input);
		if (!m.find())
			output = "No duplicates found, no changes made to data";
		else {
			while (m.find()) {
				if (output == "") {
					output = input.replaceFirst(m.group(), m.group(1));
				} else {
					output = output.replaceAll(m.group(), m.group(1));
				}
			}
			input = output;
			m = p.matcher(input);
			while (m.find()) {
				output = "";
				if (output == "") {
					output = input.replaceAll(m.group(), m.group(1));
				} else {
					output = output.replaceAll(m.group(), m.group(1));
				}
			}
		}
		System.out.println(output);

	}

}
