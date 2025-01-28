import java.util.Random;

public class StudentScores {

    public static int[][] getScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = 50 + rand.nextInt(51);
            scores[i][1] = 50 + rand.nextInt(51);
            scores[i][2] = 50 + rand.nextInt(51);
        }
        return scores;
    }

    public static double[][] calculateTotalAveragePercentage(int[][] scores, int numStudents) {
        double[][] results = new double[numStudents][4];
        for (int i = 0; i < numStudents; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3;
            double percentage = (total / 300) * 100;
            results[i][0] = Math.round(total * 100.0) / 100.0;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    public static void displayScorecard(int[][] scores, double[][] results, int numStudents) {
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Student", "Physics", "Chemistry", "Maths", "Total", "Percentage");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-10d%-10d%-10d%-10d%-10.2f%-10.2f\n", (i + 1), scores[i][0], scores[i][1], scores[i][2], results[i][0], results[i][2]);
        }
    }

    public static void main(String[] args) {
        int numStudents = 5;
        int[][] scores = getScores(numStudents);
        double[][] results = calculateTotalAveragePercentage(scores, numStudents);
        displayScorecard(scores, results, numStudents);
    }
}
