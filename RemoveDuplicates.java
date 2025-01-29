import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();
        
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256];
        
        for (char c : input.toCharArray()) {
            if (!seen[c]) {
                result.append(c);
                seen[c] = true;
            }
        }
        
        System.out.println("Modified string: " + result.toString());
    }
}
