package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class StudentCSVFilter {
    public static void main(String[] args) {
        // Specify the path to your CSV file
        String filePath = "src/main/resources/students.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read all records from the CSV file
            List<String[]> records = reader.readAll();

            System.out.println("Students with Marks > 80:");
            System.out.println("-------------------------------------");

            // Skip the header row (index 0) and iterate through the records
            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                // Assuming the 'Marks' column is at index 3
                int marks = Integer.parseInt(row[3]);
                if (marks > 80) {
                    System.out.printf("ID: %s | Name: %s | Age: %s | Marks: %s%n",
                            row[0], row[1], row[2], row[3]);
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}