import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number1: ");
        int number1 = scanner.nextInt();
        
        System.out.print("Enter number2: ");
        int number2 = scanner.nextInt();
        
        // Swapping the numbers
        int temp = number1;
        number1 = number2;
        number2 = temp;
        
        System.out.println("The swapped numbers are " + number1 + " and " + number2);
    }
}
