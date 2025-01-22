import java.util.Scanner;

public class TriangleAreaCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the base of the triangle: ");
        double base = input.nextDouble();
        
        System.out.print("Enter the height of the triangle: ");
        double height = input.nextDouble();
        
        double areaSquareInches = 0.5 * base * height;
        double areaSquareCentimeters = areaSquareInches * 6.4516; // 1 square inch = 6.4516 square centimeters
        
        System.out.println("The area of the triangle in square inches is " + areaSquareInches + 
                           " and in square centimeters is " + areaSquareCentimeters);
    }
}
