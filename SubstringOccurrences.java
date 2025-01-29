import java.util.Scanner;

public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the main string: ");
        String input = scanner.nextLine();
        System.out.print("Enter the substring to count: ");
        String substring = scanner.nextLine();
        scanner.close();
        
        int count = 0;
        int index = 0;
        
        while ((index = input.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        
        System.out.println("Occurrences: " + count);
    }
}

