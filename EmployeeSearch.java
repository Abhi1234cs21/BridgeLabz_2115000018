package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class EmployeeSearch {
    public static void main(String[] args) {
        // Specify the path to your CSV file
        String filePath = "src/main/resources/employees.csv";
        // Define the employee name to search for
        String searchName = "Alice Johnson"; // Change this value as needed
        boolean found = false;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read all records from the CSV file
            List<String[]> records = reader.readAll();

            // Assuming header: ID,Name,Department,Salary
            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                // Compare the employee name (at index 1) ignoring case
                if (row[1].equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found:");
                    System.out.println("Name: " + row[1]);
                    System.out.println("Department: " + row[2]); // Department is at index 2
                    System.out.println("Salary: " + row[3]);     // Salary is at index 3
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee with name '" + searchName + "' not found.");
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}