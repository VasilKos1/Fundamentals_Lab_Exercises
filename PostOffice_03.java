package DEMO.REGEX_MoreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PostOffice_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\|"))
                        .collect(Collectors.toList());

        Pattern firstWord = Pattern.compile("([#$%*&])([A-Z]+)\\1");  // ([A-Z]+) ->2nd captur. group
        Matcher firstLetters = firstWord.matcher(numbers.get(0));
        Map<Character, Integer> output = new LinkedHashMap<>();

        while (firstLetters.find()) {
            for (int i = 0; i < firstLetters.group(2).length(); i++) {
                output.put(firstLetters.group(2).charAt(i),0);
            }
        }
        Pattern secondWord = Pattern.compile("([\\d]{2}):([\\d]{2})");
        Matcher secondLetters = secondWord.matcher(numbers.get(1));
        while (secondLetters.find()) {
            char letter =  (char)Integer.parseInt(secondLetters.group(1));
            int length = Integer.parseInt(secondLetters.group(2)) + 1;
            if (output.containsKey(letter)) {
                output.put(letter, length);
            }
        }
        String[] wordToCheck = numbers.get(2).split(" ");
        output.forEach((key, value) -> Arrays.stream(wordToCheck)
               .filter(s -> s.length() == value && s.charAt(0) == key).forEach(System.out::println));

        // without the filter, will print all words from part 3






    }
}
