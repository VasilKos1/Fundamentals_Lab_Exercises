package DEMO.REGEX_Lab;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

                      //\\+359([ -])2(\\1)[0-9]{3}(\\1)[0-9]{4}\\b
        String regex = "\\+359([- ])2\\1[\\d]{3}\\1[\\d]{4}\\b"; //  \1 matches the same text as most recently matched by the 1st capturing group
        String input = scanner.nextLine();                       //  \1 - back-reference for 1st capturing group

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> matchedPhones = new LinkedList<>();  // We can also save our matches in a List if we need.
        while (matcher.find()){
            matchedPhones.add(matcher.group());
        }
        System.out.println(String.join(", ",matchedPhones));
    }
}
