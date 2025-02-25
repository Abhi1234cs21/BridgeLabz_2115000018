package org.example;



import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVReaderExample {
    public static void main(String[] args) {
        String filePath = "src/main/resources/students.csv"; // Path to the CSV file

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            // Print CSV Data in a Structured Format
            System.out.println("Student Details:");
            System.out.println("-------------------------------------");

            // Loop through records, skipping the header row
            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                System.out.printf("ID: %s | Name: %s | Age: %s | Marks: %s%n",
                        row[0], row[1], row[2], row[3]);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
