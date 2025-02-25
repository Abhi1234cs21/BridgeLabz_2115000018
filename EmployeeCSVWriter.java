package org.example;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class EmployeeCSVWriter {
    public static void main(String[] args) {
        String filePath = "src/main/resources/employees.csv";
        // Employee data
        String[][] employees = {
                {"ID", "Name", "Department", "Salary"},
                {"101", "Alice Johnson", "HR", "55000"},
                {"102", "Bob Smith", "IT", "75000"},
                {"103", "Charlie Brown", "Finance", "60000"},
                {"104", "David White", "Marketing", "58000"},
                {"105", "Emma Watson", "Sales", "62000"}
        };

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            for (String[] employee : employees) {
                writer.writeNext(employee);
            }
            System.out.println("CSV file written successfully: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }
}
