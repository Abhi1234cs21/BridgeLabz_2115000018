import java.util.Scanner;

public class SpaceReducer {
    public static String reduceSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim(); // Replace multiple spaces & trim leading/trailing spaces
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text = scanner.nextLine();

        String result = reduceSpaces(text);
        System.out.println("\nModified Sentence:\n" + result);

        scanner.close();
    }
}
