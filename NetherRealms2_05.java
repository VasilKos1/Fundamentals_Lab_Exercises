package DEMO.REGEX_Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms2_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<Integer, Double>> info = new TreeMap<>();  // health - int; damage - double

        Pattern healthRegex = Pattern.compile("[^\\d\\-+*/.]"); //sum of the asci codes of all characters (excluding numbers (0-9), arithmetic symbols ('+', '-', '*', '/') and delimiter dot ('.'))
        Pattern multiRegex = Pattern.compile("[*/]");                // symbols ('*' and '/') that can further alter the base
        Pattern numberRegex = Pattern.compile("(-?\\d+(\\.\\d+)?)");
        String[] input = scanner.nextLine().split(",\\s*");    //separated by commas and !!zero or more spaces

        int health = 0;
        double damage = 0.0;

        for (String s : input) {
            Matcher healthCheck = healthRegex.matcher(s);
            while (healthCheck.find()) {
                health += healthCheck.group().charAt(0);
            }
            Matcher numberCheck = numberRegex.matcher(s);
            while (numberCheck.find()) {
                damage += Double.parseDouble(numberCheck.group());
            }
            Matcher multiCheck = multiRegex.matcher(s);
            while (multiCheck.find()) {
                damage = multiCheck.group().equals("*") ? damage * 2 : damage / 2;
            }
            info.put(s, new HashMap<>());
            info.get(s).put(health, damage);
            damage = 0.0;
            health = 0;
        }
        info.forEach((key, value) -> value.forEach((key1, value1) ->
                System.out.printf("%s - %d health, %.2f damage%n", key, key1, value1)));
    }
}
