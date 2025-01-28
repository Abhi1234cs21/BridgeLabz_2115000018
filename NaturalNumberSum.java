import java.util.Scanner;

public class NaturalNumberSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("The input is not a natural number.");
            return;
        }

        int recursiveSum = calculateSumRecursive(number);
        int formulaSum = calculateSumFormula(number);

        System.out.println("Sum using recursion: " + recursiveSum);
        System.out.println("Sum using formula: " + formulaSum);

        if (recursiveSum == formulaSum) {
            System.out.println("The results from both computations are correct and match.");
        } else {
            System.out.println("The results do not match.");
        }
    }

    public static int calculateSumRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n + calculateSumRecursive(n - 1);
    }

    public static int calculateSumFormula(int n) {
        return n * (n + 1) / 2;
    }
}
