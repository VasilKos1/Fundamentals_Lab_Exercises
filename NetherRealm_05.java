package DEMO.REGEX_Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealm_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] demons = input.split(",\\s*"); // commas and !!!zero or more spaces

        Map<String, List<Double>> healthMap = new TreeMap<>();

        for (int i = 0; i < demons.length; i++) {
            String currDemon = demons[i].replaceAll("\\s+", "");

            String regexHealth = "[^0-9+\\-*\\/\\.]";  //sum of the asci codes of all characters (excluding numbers (0-9), arithmetic symbols ('+', '-', '*', '/') and delimiter dot ('.')
            Pattern healthPattern = Pattern.compile(regexHealth);
            Matcher healthMatcher = healthPattern.matcher(currDemon);
            double health = 0;

            while (healthMatcher.find()) {
                String currentLetter = healthMatcher.group();
                char currentChar = currentLetter.charAt(0);
                health += currentChar;
            }
            String regexDamage = "(?<operator>[+-]?)(?<digit>\\d+\\.?\\d*)"; // The sum of all numbers in his name forms his base damage
            Pattern patternDamage = Pattern.compile(regexDamage);
            Matcher damageMatcher = patternDamage.matcher(currDemon);

            double realDamage = 0;
            while (damageMatcher.find()) {
                String operator = damageMatcher.group("operator");
                double digit = Double.parseDouble(damageMatcher.group("digit"));
                if (operator.equals("-")) {     // Note that you should consider the plus '+' and minus '-' signs (e.g. +10 is 10 and -10 is -10
                    realDamage = realDamage - digit;
                } else {
                    realDamage += digit;
                }
            }
            String additionalDamageRegex = "[*\\/]";           //However, there are some symbols ('*' and '/') that can further alter the base damage
            Pattern additionalPattern = Pattern.compile(additionalDamageRegex);  // by multiplying or dividing it by 2
            Matcher additionalMatcher = additionalPattern.matcher(currDemon);
            while(additionalMatcher.find()){
                String additionalDamage = additionalMatcher.group();
                char current = additionalDamage.charAt(0);
                if (current == '*') {
                    realDamage = realDamage * 2;
                } else {
                    realDamage = realDamage / 2;
                }
            }
            healthMap.putIfAbsent(currDemon,new ArrayList<>(Arrays.asList(0.0 , 0.0)));
            double oldHealth = healthMap.get(currDemon).get(0);
            healthMap.get(currDemon).set(0,oldHealth + health);

            double oldDamage = healthMap.get(currDemon).get(1);
            healthMap.get(currDemon).set(1,oldDamage + realDamage);
        }
        for (Map.Entry<String,List <Double>> entry : healthMap.entrySet()){
            System.out.printf("%s - %.0f health, %.2f damage%n", entry.getKey(),
                    entry.getValue().get(0),entry.getValue().get(1));
        }
    }
}
