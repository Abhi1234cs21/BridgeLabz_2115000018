import java.util.Scanner;
public class SpringSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
            System.out.println("Enter the month:- ");
            int month = sc.nextInt();
			System.out.println("Enter the day:- ");
            int day = sc.nextInt();

            boolean isSpring = false;

            if (month == 3 && day >= 20 && day <= 31) {
                isSpring = true;
            } else if (month == 4 && day >= 1 && day <= 30) {
                isSpring = true;
            } else if (month == 5 && day >= 1 && day <= 31) {
                isSpring = true;
            } else if (month == 6 && day >= 1 && day <= 20) {
                isSpring = true;
            }

            if (isSpring) {
                System.out.println("It's a Spring Season");
            } else {
                System.out.println("Not a Spring Season");
            }
        
    }
}
