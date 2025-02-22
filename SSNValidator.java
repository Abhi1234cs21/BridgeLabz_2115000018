import java.util.*;
import java.util.regex.*;

public class SSNValidator {
    public static boolean isValidSSN(String ssn) {
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ssn);
        return matcher.find();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence containing an SSN:");
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            found = true;
            System.out.println("\"" + matcher.group() + "\" is a valid SSN.");
        }

        if (!found) {
            System.out.println("No valid SSN found.");
        }

        scanner.close();
    }
}
