import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Amar's age: ");
        int amarAge = scanner.nextInt();
        System.out.print("Enter Amar's height: ");
        int amarHeight = scanner.nextInt();

        System.out.print("Enter Akbar's age: ");
        int akbarAge = scanner.nextInt();
        System.out.print("Enter Akbar's height: ");
        int akbarHeight = scanner.nextInt();

        System.out.print("Enter Anthony's age: ");
        int anthonyAge = scanner.nextInt();
        System.out.print("Enter Anthony's height: ");
        int anthonyHeight = scanner.nextInt();

        int youngestAge = Math.min(amarAge, Math.min(akbarAge, anthonyAge));
        int tallestHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));

        System.out.println("The youngest friend is " + youngestAge + " years old.");
        System.out.println("The tallest friend is " + tallestHeight + " cm tall.");
    }
}
