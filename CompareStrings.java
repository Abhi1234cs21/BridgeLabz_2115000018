import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();
        scanner.close();
        
        int minLength = Math.min(str1.length(), str2.length());
        int result = 0;
        
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                result = str1.charAt(i) - str2.charAt(i);
                break;
            }
        }
        
        if (result == 0 && str1.length() != str2.length()) {
            result = str1.length() - str2.length();
        }
        
        if (result < 0) {
            System.out.println("First string comes before second string.");
        } else if (result > 0) {
            System.out.println("First string comes after second string.");
        } else {
            System.out.println("Both strings are equal.");
        }
    }
}
