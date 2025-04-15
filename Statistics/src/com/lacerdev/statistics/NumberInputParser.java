package com.lacerdev.statistics;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberInputParser {
    static final String NUMBER_REGEX_PATTERN = "\\d+\\.?\\d*|\\d*\\.?\\d+";

    /**
     * Reads all of the numbers entered from standard input and parses them into a list.
     * <p>
     * Reads from the standard input stream until End-of-File (EOF) is entered. 
     * The numbers can be separated by any delimiter (except EOF). The regex
     * used to parse the numbers can differentiate between numbers and delimeters.
     * <p>
     * Example input:<br>
     * 1 2 3 4<br>
     * 5, 6, 7, 8<br>
     * 9, 10 11, 12 13, 15, 16.54 17.<br>
     * .18 ^D<br>
     * Result:<br>
     * [1 2 3 4 5 6 7 8 9 10 11 12 13 15 16.54 17. .18]
     */
    List<Double> readNumbersAsList() {
        // Reading from standard input
        SystemInputBufferedReader reader = new SystemInputBufferedReader();
        // Match all numbers
        Pattern pattern = Pattern.compile(NUMBER_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(reader.readUntilEOF());
        
        List<Double> numbers = new ArrayList<>();
        while (matcher.find()) {
            numbers.add(Double.parseDouble(matcher.group()));
        }
        return numbers;
    }

    Double readDouble() {
        // Reading from standard input
        SystemInputBufferedReader reader = new SystemInputBufferedReader();
        // Match all numbers
        Pattern pattern = Pattern.compile(NUMBER_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(reader.readUntilEOF());

        if (matcher.find()) {
            return Double.parseDouble(matcher.group());
        } else {
            return null;
        }
    }
}