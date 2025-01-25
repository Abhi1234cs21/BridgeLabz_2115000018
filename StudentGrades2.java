import java.util.Scanner;

public class StudentGrades2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5; // number of students
        int m = 3; // number of subjects (Physics, Chemistry, Maths)
        int[][] marks = new int[n][m];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for Student " + (i + 1));
            for (int j = 0; j < m; j++) {
                System.out.print("Enter marks for subject " + (j + 1) + ": ");
                marks[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int totalMarks = 0;
            for (int j = 0; j < m; j++) {
                totalMarks += marks[i][j];
            }
            percentage[i] = (totalMarks / (double) (m * 100)) * 100;

            if (percentage[i] >= 90) {
                grade[i] = 'A';
            } else if (percentage[i] >= 75) {
                grade[i] = 'B';
            } else if (percentage[i] >= 50) {
                grade[i] = 'C';
            } else {
                grade[i] = 'D';
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": Percentage = " + percentage[i] + "%, Grade = " + grade[i]);
        }

        sc.close();
    }
}
