package DEMO.REGEX_Exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //String regex = "[>]{2}(?<name>[A-Za-z]+)[<]{2}(?<price>[\\d]+[.]?[\\d]+?)[!](?<quantity>[\\d])";
        String regex = "\\>\\>(?<name>(\\w+))\\<\\<(?<price>([0-9]+\\.[0-9]+)|(\\d+))\\!(?<quantity>([0-9]+))";
                                      // 2436.69   [\\d]+[.]?[\\d]+?   or    [0-9]+\\.[0-9]+
        double sum = 0;
        System.out.println("Bought furniture:");

        while (!input.equals("Purchase")) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){
                String name = matcher.group("name");
                Double price = Double.parseDouble(matcher.group("price"));
                Integer quantity = Integer.parseInt(matcher.group("quantity"));

                System.out.println(matcher.group("name"));   // !!! "name"
                sum += price * quantity;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total money spend: %.2f", sum);

    }
}
