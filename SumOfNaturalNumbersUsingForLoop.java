import java.util.Scanner;

public class SumOfNaturalNumbersUsingForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("The number " + n + " is not a natural number.");
        } else {
            int formulaSum = n * (n + 1) / 2;

            int forLoopSum = 0;
            for (int i = 1; i <= n; i++) {
                forLoopSum += i;
            }

            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using for loop: " + forLoopSum);

            if (formulaSum == forLoopSum) {
                System.out.println("Both methods give the correct result.");
            } else {
                System.out.println("There is an error in the computation.");
            }
        }

    }
}
