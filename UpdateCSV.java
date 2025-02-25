package org.example;



import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFile = "src/main/resources/employees.csv";
        String outputFile = "src/main/resources/updated_employees.csv";

        try {
            updateSalaries(inputFile, outputFile);
            System.out.println("Salaries updated successfully.");
        } catch (IOException | CsvValidationException e) {
            System.err.println("Error processing CSV file: " + e.getMessage());
        }
    }

    public static void updateSalaries(String inputFile, String outputFile) throws IOException, CsvValidationException {
        List<String[]> data = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(inputFile))) {
            String[] header = csvReader.readNext();
            if (header != null) {
                data.add(header);
            }

            String[] row;
            while ((row = csvReader.readNext()) != null) {
                if (row.length >= 4 && row[2].trim().equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(row[3].trim());
                    row[3] = String.valueOf(salary * 1.1);
                }
                data.add(row);
            }
        }

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(outputFile))) {
            csvWriter.writeAll(data);
        }
    }
}

