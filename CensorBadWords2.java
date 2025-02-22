import java.util.Scanner;

public class CensorBadWords2 {
    public static String censorText(String text) {
        // List of bad words to be censored
        String[] badWords = {"damn", "stupid"}; 
        
        // Replace each bad word with "****"
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****"); 
        }
        
        return text;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text = scanner.nextLine();

        String censoredText = censorText(text);
        System.out.println("\nCensored Sentence:\n" + censoredText);

        scanner.close();
    }
}
