import java.util.Scanner;
public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();
        System.out.print("Enter your years of service: ");
        int yearsOfService = sc.nextInt();
        // Calculate and print the bonus
        if (yearsOfService > 5) {
            double bonus = salary * 0.05;  // 5% bonus
            System.out.println("You are eligible for a bonus of: " + bonus);
        } else {
            System.out.println("You are not eligible for a bonus.");
        }
        sc.close();
    }
}
