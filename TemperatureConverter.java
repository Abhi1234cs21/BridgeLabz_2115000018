import java.util.Scanner;

public class TemperatureConverter {
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter temperature: ");
        double temperature = scanner.nextDouble();
        
        System.out.println("Convert to (1) Celsius or (2) Fahrenheit?");
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            System.out.println("Converted Temperature: " + fahrenheitToCelsius(temperature) + " °C");
        } else if (choice == 2) {
            System.out.println("Converted Temperature: " + celsiusToFahrenheit(temperature) + " °F");
        } else {
            System.out.println("Invalid choice.");
        }
        
        scanner.close();
    }
}
