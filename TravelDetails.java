import java.util.Scanner;

public class TravelDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your from city: ");
        String fromCity = scanner.nextLine();
        
        System.out.print("Enter your via city: ");
        String viaCity = scanner.nextLine();
        
        System.out.print("Enter your to city: ");
        String toCity = scanner.nextLine();
        
        System.out.print("Enter distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = scanner.nextDouble();
        
        System.out.print("Enter distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = scanner.nextDouble();
        
        System.out.print("Enter time taken for the journey in hours: ");
        double timeTaken = scanner.nextDouble();
        
        double totalDistance = fromToVia + viaToFinalCity;
        double averageSpeed = totalDistance / timeTaken;
        
        System.out.println(name + " is traveling from " + fromCity + " to " + viaCity + " and finally to " + toCity);
        System.out.println("The total distance covered is " + totalDistance + " miles.");
        System.out.println("The average speed of the journey is " + averageSpeed + " miles per hour.");
    }
}
