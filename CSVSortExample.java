package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVSortExample {
    public static void main(String[] args) {
        // Specify the path to your CSV file
        String filePath = "src/main/resources/employees.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read all records from the CSV file
            List<String[]> records = reader.readAll();

            // Ensure there are records to process
            if (records.size() <= 1) {
                System.out.println("No employee records found.");
                return;
            }

            // Extract and remove the header row
            String[] header = records.remove(0);

            // Sort the records by the 'Salary' column (index 3) in descending order
            records.sort((row1, row2) -> {
                double salary1 = Double.parseDouble(row1[3]);
                double salary2 = Double.parseDouble(row2[3]);
                return Double.compare(salary2, salary1); // Descending order
            });

            // Print the header (optional)
            System.out.println("Top 5 Highest-Paid Employees:");
            System.out.println(String.join(", ", header));

            // Determine the number of records to print (top 5 or fewer if less data)
            int topCount = Math.min(5, records.size());
            for (int i = 0; i < topCount; i++) {
                String[] row = records.get(i);
                System.out.println(String.join(", ", row));
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}

