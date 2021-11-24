package DEMO.REGEX_MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split(",\\s+"); //separated by commas and spaces
        for (String ticket : tickets) {
            ticket = ticket.trim();
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }
            String leftPart = ticket.substring(0, ticket.length() / 2);
            String rightPart = ticket.substring(ticket.length() / 2);

            String regex = "(?<name>[$]{6,10}|[\\^]{6,10}|[#]{6,10}|[@]{6,10})"; //winning symbols are '@', '#', '$' and '^'.
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(leftPart);

            String leftMatch = "";
            if (matcher.find()) {
                leftMatch = matcher.group("name");
            }
            matcher = pattern.matcher(rightPart);

            String rightMatch = "";
            if (matcher.find()) {
                rightMatch = matcher.group("name");
            }
            int minLength = Math.min(leftMatch.length(), rightMatch.length());
            boolean equalSymbols = leftMatch.charAt(0) == rightMatch.charAt(0);

            if (!equalSymbols) {
                System.out.printf("ticket \"%s\" - no match%n", ticket);
            } else if (minLength == 10) {
                System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", ticket, minLength, leftMatch.charAt(0));
            } else {
                System.out.printf("ticket \"%s\" - %d%c%n", ticket, minLength, leftMatch.charAt(0));
            }
        }

    }
}
