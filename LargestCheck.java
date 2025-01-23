import java.util.Scanner;

public class LargestCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();

        System.out.print("Enter the third number: ");
        int number3 = scanner.nextInt();

        boolean isLargest1 = (number1 > number2) && (number1 > number3);
		boolean isLargest2 = (number2 > number1) && (number2 > number3);
        boolean isLargest3 = (number3 > number2) && (number3 > number1);


        if (isLargest1) {
            System.out.println("Is the first number the largest? Yes");
        } else {
            System.out.println("Is the first number the largest? No");
        }
		if (isLargest2) {
            System.out.println("Is the second number the largest? Yes");
        } else {
            System.out.println("Is the second number the largest? No");
        }
		if (isLargest3) {
            System.out.println("Is the third number the largest? Yes");
        } else {
            System.out.println("Is the third number the largest? No");
        }
    }
}
