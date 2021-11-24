package DEMO.REGEX_Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //	Pattern Class − A Pattern object is a compiled representation of a regular expression
        //	Matcher Class − A Matcher object is the engine that interprets the pattern and performs match operations against an input string.

        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // We use matcher method find(), which attempts to find the next subsequence of the input sequence that matches the pattern.
        // To get our matches, we need to use method group().

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }


    }
}
