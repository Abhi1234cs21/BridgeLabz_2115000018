import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter marks for the following subjects (out of 100):");
        System.out.print("Physics: ");
        float physics = scanner.nextFloat();
        System.out.print("Chemistry: ");
        float chemistry = scanner.nextFloat();
        System.out.print("Maths: ");
        float maths = scanner.nextFloat();

        if (physics < 0 || physics > 100 || chemistry < 0 || chemistry > 100 || maths < 0 || maths > 100) {
            System.out.println("Error: Marks should be between 0 and 100 for all subjects.");
            return;
        }

        float totalMarks = physics + chemistry + maths;
        float percentage = (totalMarks / 300) * 100;

        String grade;
        String remarks;

        if (percentage >= 80) {
            grade = "A";
            remarks = "Level 4, above agency-normalized standards";
        } else if (percentage >= 70) {
            grade = "B";
            remarks = "Level 3, at agency-normalized standards";
        } else if (percentage >= 60) {
            grade = "C";
            remarks = "Level 2, below, but approaching agency-normalized standards";
        } else if (percentage >= 50) {
            grade = "D";
            remarks = "Level 1, well below agency-normalized standards";
        } else if (percentage >= 40) {
            grade = "E";
            remarks = "Level 1-, too below agency-normalized standards";
        } else {
            grade = "R";
            remarks = "Remedial standards";
        }

        System.out.println("\nTotal Marks: " + totalMarks + "/300");
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
    }
}