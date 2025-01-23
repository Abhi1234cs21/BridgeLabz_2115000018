import java.util.Scanner;

public class RocketLaunchCountdownForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the countdown start number: ");
        int counter = scanner.nextInt();

        for (int i = counter; i >= 1; i--) {
            System.out.println("T-" + i + " seconds");
        }

        System.out.println("Launch!");

    }
}
