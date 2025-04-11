import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberInputParser {
    /**
     * Reads the whole of standard input until hit an EOF.
     * An EOF can be entered in the terminal with the shortcut `ctrl + d` (Linux) or `ctrl + z` (Windows).
     */
    class InEOFScanner {
        Scanner internal_scanner = new Scanner(System.in);
        public String next() {
            String result = "";
            if (internal_scanner.hasNext()) {
                result += internal_scanner.nextLine();
            }
            return result;
        }
    }

    static final String NUMBER_REGEX_PATTERN = "\\d+\\.?\\d*|\\d*\\.?\\d+";
    /**
     * Reads all of the numbers entered from standard input and parses them into a list.
     * 
     * Reads from the standard input stream until End-of-File (EOF) is entered. 
     * The numbers can be separated by any delimiter (except EOF). The regex
     * used to parse the numbers can differentiate between numbers and delimeters.
     * 
     * Example input:
     * 1 2 3 4
     * 5, 6, 7, 8
     * 9, 10 11, 12 13, 15, 16.54 17.
     * .18 ^D
     * Result:
     * [1 2 3 4 5 6 7 8 9 10 11 12 13 15 16.54 17. .18]
     */
    List<Double> parseToList() {
        // Reading from standard input
        InEOFScanner s = new InEOFScanner();
        
        // Match all numbers
        Pattern pattern = Pattern.compile(NUMBER_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(s.next());
        
        List<Double> numbers =  new ArrayList<>();
        while (matcher.find()) {
            numbers.add(Double.parseDouble(matcher.group()));
        }
        return numbers;
    }

    Double parseDouble() {
        // Reading from standard input
        InEOFScanner s = new InEOFScanner();
        
        // Match next number
        Pattern pattern = Pattern.compile(NUMBER_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(s.next());
        return (matcher.find()) ? Double.parseDouble(matcher.group()) : null;
    }
}