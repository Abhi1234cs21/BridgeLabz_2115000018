import java.util.Scanner;

public class CreditCardValidator {
    public static boolean isValidVisa(String cardNumber) {
        return cardNumber.matches("^4[0-9]{15}$"); // Visa: Starts with 4, 16 digits
    }

    public static boolean isValidMasterCard(String cardNumber) {
        return cardNumber.matches("^5[0-9]{15}$"); // MasterCard: Starts with 5, 16 digits
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a credit card number:");
        String cardNumber = scanner.nextLine();

        if (isValidVisa(cardNumber)) {
            System.out.println("Valid Visa Card");
        } else if (isValidMasterCard(cardNumber)) {
            System.out.println("Valid MasterCard");
        } else {
            System.out.println("Invalid Credit Card Number");
        }

        scanner.close();
    }
}
