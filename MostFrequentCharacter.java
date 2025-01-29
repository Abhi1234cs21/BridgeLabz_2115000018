import java.util.Scanner;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();
        
        int[] frequency = new int[256];
        for (char c : input.toCharArray()) {
            frequency[c]++;
        }
        
        char mostFrequent = input.charAt(0);
        int maxCount = 0;
        
        for (char c : input.toCharArray()) {
            if (frequency[c] > maxCount) {
                maxCount = frequency[c];
                mostFrequent = c;
            }
        }
        
        System.out.println("Most Frequent Character: '" + mostFrequent + "'");
    }
}
