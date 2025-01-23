import java.util.Scanner;
public class HarshadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int temp = number, sum = 0;

        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }

        if (number % sum == 0) {
            System.out.println("Harshad Number");
        } else {
            System.out.println("Not a Harshad Number");
        }
    }
}
