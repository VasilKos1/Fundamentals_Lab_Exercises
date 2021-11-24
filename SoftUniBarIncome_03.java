package DEMO.REGEX_Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Greedy - match longest possible string;          Lazy - shortest possible
        // * greedy VS   *? lazy   without them the code breaks ???
        //String regex = "[%](?<name>[A-Z][a-z]+)[%][^$%|.]*[<](?<product>[\\w]+)[>][^$%|.]*[\\|](?<quantity>[\\d])[\\|][^$%|.]*?(?<price>[\\d]+[.]?[\\d]+?)[$]";
        String regex = "%(?<name>[A-Z][a-z]+)%[^$%|.]*<(?<product>\\w+)>[^$%|.]*\\|(?<quantity>\\d+)\\|[^$%|.]*?(?<price>\\d+\\.?\\d+)\\$";
        double totalSum=0;

        String input = scanner.nextLine();
        while (!input.equals("end of shift")) {
            double sumPerProduct = 0;
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                Double price = Double.parseDouble(matcher.group("price"));
                Integer quantity = Integer.parseInt(matcher.group("quantity"));

                sumPerProduct += price * quantity;
                totalSum+=sumPerProduct;
                System.out.printf("%s: %s - %.2f%n",name,product,sumPerProduct);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f",totalSum);



    }
}
