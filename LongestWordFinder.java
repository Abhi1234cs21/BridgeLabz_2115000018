import java.util.Scanner;

public class LongestWordFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        scanner.close();
        
        String[] words = input.split(" ");
        String longestWord = "";
        
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        
        System.out.println("Longest word: " + longestWord);
    }
}
