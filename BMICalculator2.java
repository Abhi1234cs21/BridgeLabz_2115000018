import java.util.Scanner;

public class BMICalculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();

        double[][] personData = new double[numPersons][3];
        String[] weightStatus = new String[numPersons];

        for (int i = 0; i < numPersons; i++) {
            double height, weight;
            do {
                System.out.print("Enter height (in meters) for person " + (i + 1) + ": ");
                height = scanner.nextDouble();
            } while (height <= 0);

            do {
                System.out.print("Enter weight (in kg) for person " + (i + 1) + ": ");
                weight = scanner.nextDouble();
            } while (weight <= 0);

            personData[i][0] = height;
            personData[i][1] = weight;
            personData[i][2] = weight / (height * height);

            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(m)", "Weight(kg)", "BMI", "Status");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s%n", personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}
