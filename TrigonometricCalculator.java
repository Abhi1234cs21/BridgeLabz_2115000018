import java.util.Scanner;

public class TrigonometricCalculator {

    public double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double[] results = new double[3];
        results[0] = Math.sin(radians);  // Sine
        results[1] = Math.cos(radians);  // Cosine
        results[2] = Math.tan(radians);  // Tangent
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the angle in degrees: ");
        double angle = scanner.nextDouble();
        
        TrigonometricCalculator calculator = new TrigonometricCalculator();
        double[] results = calculator.calculateTrigonometricFunctions(angle);
        
        System.out.println("Sine: " + results[0]);
        System.out.println("Cosine: " + results[1]);
        System.out.println("Tangent: " + results[2]);
        
    }
}
