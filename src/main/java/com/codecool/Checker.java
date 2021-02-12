package com.codecool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;

public class Checker {
    public void check(final String fileName, final String s, final com.codecool.StringHasher stringHasher, final PrintStream printStream) throws IOException {
        final com.codecool.WordList list = new com.codecool.WordList(s, stringHasher);
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String x = bufferedReader.readLine();
        com.codecool.WordLineReader wordLineReader = new com.codecool.WordLineReader(x);
        final WordChecker wordChecker = new WordChecker(list);
        while (x != null) {
            while (wordLineReader.hasNextWord()) {
                final String upperCase = wordLineReader.nextWord().toUpperCase();
                if (!wordChecker.wordExists(upperCase)) {
                    final List<String> suggestions = wordChecker.getSuggestions(upperCase);
                    printStream.println();
                    printStream.println(x);
                    printStream.println("     word not found: " + upperCase);
                    if (suggestions.size() <= 0) {
                        continue;
                    }
                    Collections.sort(suggestions);
                    printStream.println("  perhaps you meant: ");
                    for (String suggestion : suggestions) {
                        printStream.println("          " + suggestion + " ");
                    }
                }
            }
            x = bufferedReader.readLine();
            wordLineReader = new com.codecool.WordLineReader(x);
        }
        bufferedReader.close();
    }
}
