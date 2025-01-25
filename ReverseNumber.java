import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int count = 0;
        int temp = number;
        while (temp != 0) {
            temp /= 10;
            count++;
        }

        int[] digits = new int[count];
        int index = 0;
        while (number != 0) {
            digits[index] = number % 10;
            number /= 10;
            index++;
        }

        System.out.print("Reversed number: ");
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]);
        }
    }
}
