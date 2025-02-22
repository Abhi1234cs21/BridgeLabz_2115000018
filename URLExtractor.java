import java.util.regex.*;
import java.util.Scanner;

public class URLExtractor {
    public static void extractURLs(String text) {
        String regex = "https?://[\\w.-]+(?:\\.[a-zA-Z]{2,})(?:/[\\w&%?=.-]*)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }
        
        if (!found) {
            System.out.println("No links found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = scanner.nextLine();

        System.out.println("\nExtracted Links:");
        extractURLs(text);

        scanner.close();
    }
}
