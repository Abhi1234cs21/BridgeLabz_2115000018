import java.util.Random;

public class EmployeeBonus {

   
    public static int[][] getEmployeeData() {
        Random rand = new Random();
        int[][] employeeData = new int[10][2]; // 10 employees, 2 columns (Salary, Years of Service)

        for (int i = 0; i < 10; i++) {
            employeeData[i][0] = 10000 + rand.nextInt(90000); // Salary between 10,000 to 99,999
            employeeData[i][1] = rand.nextInt(11); // Years of service between 0 to 10
        }
        return employeeData;
    }

 
    public static int[][] calculateBonusAndNewSalary(int[][] employeeData) {
        int[][] updatedData = new int[10][3]; // 10 employees, 3 columns (Old Salary, Bonus, New Salary)
        for (int i = 0; i < 10; i++) {
            int oldSalary = employeeData[i][0];
            int yearsOfService = employeeData[i][1];
            double bonusPercentage = yearsOfService >= 5 ? 0.05 : 0.02; // 5% bonus for more than 5 years, 2% for less
            double bonus = oldSalary * bonusPercentage;
            int newSalary = (int)(oldSalary + bonus);

            updatedData[i][0] = oldSalary; // Old Salary
            updatedData[i][1] = (int)bonus; // Bonus
            updatedData[i][2] = newSalary; // New Salary
        }
        return updatedData;
    }

    public static void calculateTotalSalariesAndBonus(int[][] updatedData) {
        int totalOldSalary = 0;
        int totalNewSalary = 0;
        int totalBonus = 0;

        for (int i = 0; i < 10; i++) {
            totalOldSalary += updatedData[i][0];
            totalNewSalary += updatedData[i][2];
            totalBonus += updatedData[i][1];
        }

        System.out.printf("%-10s%-15s%-15s%-15s\n", "Employee", "Old Salary", "Bonus", "New Salary");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-10d%-15d%-15d%-15d\n", (i + 1), updatedData[i][0], updatedData[i][1], updatedData[i][2]);
        }
        System.out.printf("\nTotal Old Salary: %d\n", totalOldSalary);
        System.out.printf("Total New Salary: %d\n", totalNewSalary);
        System.out.printf("Total Bonus Paid: %d\n", totalBonus);
    }

    public static void main(String[] args) {
        int[][] employeeData = getEmployeeData();
        int[][] updatedData = calculateBonusAndNewSalary(employeeData);
        calculateTotalSalariesAndBonus(updatedData);
    }
}
