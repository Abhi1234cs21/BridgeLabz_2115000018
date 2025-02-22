import java.util.*;
import java.util.regex.*;

public class ProgrammingLanguageExtractor {
    public static List<String> extractLanguages(String text) {
        // List of common programming languages
        String[] languages = {"JavaScript", "Java", "Python", "C\\+\\+", "C#", "Go", "Swift", "Ruby", "PHP", "TypeScript", "Kotlin", "Rust", "Dart", "Scala"};

        // Create a regex pattern to match programming languages
        String regex = "\\b(" + String.join("|", languages) + ")\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Use a set to store unique matches
        List<String> foundLanguages = new ArrayList<>();
        while (matcher.find()) {
            foundLanguages.add(matcher.group());
        }

        return foundLanguages;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a text:");
        String text = scanner.nextLine();

        List<String> extractedLanguages = extractLanguages(text);

        System.out.println("\nExtracted Programming Languages:");
        for (String lang : extractedLanguages) {
            System.out.println(lang); // Print each language on a new line
        }

        scanner.close();
    }
}
