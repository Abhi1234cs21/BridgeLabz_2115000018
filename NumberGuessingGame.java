import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int low = 1, high = 100, guess;
        String feedback = "";

        System.out.println("Think of a number between 1 and 100, and I will try to guess it!");

        while (!feedback.equals("correct")) {
            guess = generateGuess(low, high, random);
            System.out.println("Is your number " + guess + "? (high/low/correct)");
            feedback = scanner.nextLine().trim().toLowerCase();
            
            if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            }
        }
        System.out.println("Great! I guessed your number!");
        scanner.close();
    }

    public static int generateGuess(int low, int high, Random random) {
        return random.nextInt(high - low + 1) + low;
    }
}
