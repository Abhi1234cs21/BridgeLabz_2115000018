import java.util.Scanner;

public class DistanceConverter2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = input.nextDouble();
        
        double feetToYards = distanceInFeet / 3;
        double yards = feetToYards;
        double miles = feetToYards / 1760;
        
        System.out.println("Your distance in yards is " + yards + 
                           " and in miles is " + miles);
    }
}
