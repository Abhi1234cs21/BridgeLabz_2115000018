import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();

        String[][] details = new String[numPersons][4];

        for (int i = 0; i < numPersons; i++) {
            System.out.print("Enter height (in meters) for person " + (i + 1) + ": ");
            double height = scanner.nextDouble();
            System.out.print("Enter weight (in kg) for person " + (i + 1) + ": ");
            double weight = scanner.nextDouble();

            double bmi = weight / (height * height);
            String status;
            if (bmi <= 18.4) {
                status = "Underweight";
            } else if (bmi <= 24.9) {
                status = "Normal";
            } else if (bmi <= 39.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            details[i][0] = String.format("%.2f", height);
            details[i][1] = String.format("%.2f", weight);
            details[i][2] = String.format("%.2f", bmi);
            details[i][3] = status;
        }

        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(m)", "Weight(kg)", "BMI", "Status");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%-10s %-10s %-10s %-15s%n", details[i][0], details[i][1], details[i][2], details[i][3]);
        }
    }
}
