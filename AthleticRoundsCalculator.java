import java.util.Scanner;

public class AthleticRoundsCalculator {
    public static double calculatePerimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    public static int calculateRounds(double perimeter, double totalDistance) {
        return (int) Math.ceil(totalDistance / perimeter);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = scanner.nextDouble();

        double perimeter = calculatePerimeter(side1, side2, side3);
        double totalDistance = 5000.0; // 5 km in meters

        if (perimeter <= 0) {
            System.out.println("Invalid triangle sides provided.");
        } else {
            int rounds = calculateRounds(perimeter, totalDistance);
            System.out.println("The athlete needs to complete " + rounds + " rounds to run 5 km.");
        }
    }
}