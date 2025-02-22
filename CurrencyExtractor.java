import java.util.*;
import java.util.regex.*;

public class CurrencyExtractor {
    public static List<String> extractCurrencyValues(String text) {
        // Regular expression to match currency values (with or without $)
        String regex = "\\$?\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> currencyValues = new ArrayList<>();
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        return currencyValues;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a text:");
        String text = scanner.nextLine();

        List<String> extractedValues = extractCurrencyValues(text);

        System.out.println("\nExtracted Currency Values:");
        for (String value : extractedValues) {
            System.out.println(value); // Print each value on a new line
        }

        scanner.close();
    }
}
