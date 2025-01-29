import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.print("Enter the character to remove: ");
        char charToRemove = scanner.next().charAt(0);
        scanner.close();
        
        StringBuilder result = new StringBuilder();
        
        for (char c : input.toCharArray()) {
            if (c != charToRemove) {
                result.append(c);
            }
        }
        
        System.out.println("Modified String: " + result.toString());
    }
}
