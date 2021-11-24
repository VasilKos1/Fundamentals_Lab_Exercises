package DEMO.REGEX_Lab;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //we’re going to match the same separator we matched earlier. We can use a back-reference for that: \2 for 2d capturing group

        String regex = "\\b(?<day>\\d{2})([-./])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String day =matcher.group("day");
            String month =matcher.group("month");
            String year =matcher.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s%n",day,month,year);
        }


    }
}
