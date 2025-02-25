package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CsvRowCounter {
    public static void main(String[] args) {
        String filePath = "src/main/resources/students.csv"; // Change this to your actual CSV file path

        try {
            long rowCount = countCsvRows(filePath);
            System.out.println("Total number of records (excluding header): " + rowCount);
        } catch (IOException | CsvValidationException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    public static long countCsvRows(String filePath) throws IOException, CsvValidationException {
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            csvReader.readNext(); // Skip the header row
            long count = 0;

            while (csvReader.readNext() != null) {
                count++; // Count each row
            }

            return count; // Number of records excluding the header
        }
    }
}

