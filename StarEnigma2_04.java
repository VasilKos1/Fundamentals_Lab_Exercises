package DEMO.REGEX_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma2_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();
        Pattern patternCount = Pattern.compile("[STARstar]");
        Pattern patternRegex = Pattern.compile("[@](?<planet>[A-Za-z]+)[^@!:>-]*:[\\d]+[^@!:>-]*!([A-Z])![^@!:>-]*->[\\d]+");

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcherCount = patternCount.matcher(input);
            int count = 0;

            while (matcherCount.find()) {
                count++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                sb.append((char) (input.charAt(j) - count));
            }
            Matcher planet = patternRegex.matcher((sb));
            if (planet.find()) {
                if (planet.group(2).equals("A")) {
                    attacked.add(planet.group("planet"));
                } else {
                    destroyed.add(planet.group("planet"));
                }
            }
        }
        System.out.printf("Attacked planets: %d%n", attacked.size());
        if (!attacked.isEmpty()) {
            attacked.stream().sorted().forEach(e -> System.out.printf("-> %s%n", e));
        }
        System.out.printf("Destroyed planets: %d%n", destroyed.size());
        if (!destroyed.isEmpty()) {
            destroyed.stream().sorted().forEach(e -> System.out.printf("-> %s%n", e));
        }
    }

}
