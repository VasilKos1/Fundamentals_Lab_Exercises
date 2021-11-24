package DEMO.REGEX_MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class RageQuit_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(?<string>[\\D]*)(?<count>\\d+)";  // D -any non-digit
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            int n = Integer.parseInt(matcher.group("count"));
            String word = matcher.group("string").toUpperCase();
            for (int i = 0; i < n; i++) {
                sb.append(word);
            }
            //IntStream.range(0,n).mapToObj(i->word).forEach(sb::append);
        }
        System.out.printf("Unique symbols used: %d%n", sb.chars().distinct().count());
        System.out.println(sb);       // distinct - removes duplicates !!!


    }

}
