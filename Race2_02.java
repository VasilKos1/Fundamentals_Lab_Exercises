package DEMO.REGEX_Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race2_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listOfRacers = Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());
        LinkedHashMap<String, Integer> racers = new LinkedHashMap<>();

        for (String racer : listOfRacers) {
            racers.putIfAbsent(racer, 0);
        }
        String input = scanner.nextLine();
        while (!input.equals("end of race")) {

            Pattern pattern = Pattern.compile("[A-Za-z]");
            Matcher matcher = pattern.matcher(input);
            StringBuilder racerName = new StringBuilder();
            while (matcher.find()) {
                racerName.append(matcher.group(0));
            }
            pattern = Pattern.compile("[\\d]");
            matcher = pattern.matcher(input);
            int racerDistance = 0;
            while (matcher.find()) {
                racerDistance += Integer.parseInt(matcher.group(0));
            }

            if (racers.containsKey(racerName.toString())) {
                racers.put(racerName.toString(), racers.get(racerName.toString()) + racerDistance);
            }
            input = scanner.nextLine();
        }
        List<String> winners = racers.entrySet().stream().
                sorted((f, s) -> s.getValue() - f.getValue()).
                limit(3).
                map(Map.Entry::getKey).
                collect(Collectors.toList());
        System.out.printf("1st place: %s%n2nd place: %s%n3rd place: %s%n%n",
                winners.get(0),
                winners.get(1),
                winners.get(2));
    }
}
