import java.util.regex.*;
import java.util.Scanner;

public class CapitalizedWordExtractor {
    public static void extractCapitalizedWords(String text) {
        String regex = "\\b[A-Z][a-z]*\\b"; 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
            found = true;
        }
        
        if (!found) {
            System.out.println("No capitalized words found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text = scanner.nextLine();

        System.out.println("\nExtracted Capitalized Words:");
        extractCapitalizedWords(text);

        scanner.close();
    }
}
