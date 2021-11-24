package DEMO.REGEX_Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> players = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split(", ");
        //List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        for (int i = 0; i < input.length; i++) {
            players.putIfAbsent(input[i], 0);       // .putIfAbsent(input.get(i),0)
        }
        String line = scanner.nextLine();
        while (!line.equals("end of race")) {
            String name = "";
            int result = 0;

            Pattern pattern = Pattern.compile("[A-Za-z]+");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                name += matcher.group(); // string concatenation in Loop, therefore String builder!!!
            }
            Pattern patternDigit = Pattern.compile("\\d");
            Matcher matcherDigit = patternDigit.matcher(line);

            while (matcherDigit.find()) {
                result += Integer.parseInt(matcherDigit.group());
            }
            if (players.containsKey(name)) {
                players.put(name, players.get(name) + result);
            }
            line = scanner.nextLine();
        }
        List<String> names = new LinkedList<>();
        players.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()
                .reversed()).limit(3).forEach(p -> names.add(p.getKey()));

        System.out.printf("1st place: %s\n" +
                "2nd place: %s\n" +
                "3rd place: %s\n", names.get(0), names.get(1), names.get(2));
    }

}
