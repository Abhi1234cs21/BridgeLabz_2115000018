import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.print("Enter character to remove: ");
        char removeChar = scanner.next().charAt(0);
        scanner.close();
        
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != removeChar) {
                result += input.charAt(i);
            }
        }
        
        System.out.println("Modified String: " + result);
    }
}
