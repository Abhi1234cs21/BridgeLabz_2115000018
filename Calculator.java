import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Input the first number
        System.out.print("Enter the first number: ");
        double first = scanner.nextDouble();

        // Input the second number
        System.out.print("Enter the second number: ");
        double second = scanner.nextDouble();

        // Input the operator
        System.out.print("Enter an operator (+, -, *, /): ");
        String op = scanner.next();

        // Perform the calculation based on the operator
        switch (op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;
            case "-":
                System.out.println("Result: " + (first - second));
                break;
            case "*":
                System.out.println("Result: " + (first * second));
                break;
            case "/":
                if (second != 0) {
                    System.out.println("Result: " + (first / second));
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid Operator.");
                break;
        }

        // Close the scanner
        scanner.close();
    }
}