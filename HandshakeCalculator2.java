import java.util.Scanner;

public class HandshakeCalculator2 {
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        if (n < 2) {
            System.out.println("The number of handshakes is 0 as there are fewer than 2 students.");
        } else {
            int handshakes = calculateHandshakes(n);
            System.out.println("The maximum number of handshakes among " + n + " students is " + handshakes + ".");
        }
    }
}