import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("The number " + n + " is not a natural number.");
        } else {
            int formulaSum = n * (n + 1) / 2;

            int whileSum = 0;
            int counter = 1;
            while (counter <= n) {
                whileSum += counter;
                counter++;
            }

            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using while loop: " + whileSum);

            if (formulaSum == whileSum) {
                System.out.println("Both methods give the correct result.");
            } else {
                System.out.println("There is an error in the computation.");
            }
        }

    }
}
