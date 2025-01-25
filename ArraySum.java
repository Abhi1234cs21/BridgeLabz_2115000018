import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a number: ");
            double input = scanner.nextDouble();
            if (input <= 0 || index == 10) {
                break;
            }
            numbers[index] = input;
            index++;
        }

        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        System.out.println("Numbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println("\nTotal: " + total);
    }
}
