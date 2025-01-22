import java.util.Scanner;

public class KmToMilesConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter distance in kilometers: ");
        double km = input.nextDouble();
        
        double kmToMilesConversion = 1.6;
        double miles = km / kmToMilesConversion;
        
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
    }
}
