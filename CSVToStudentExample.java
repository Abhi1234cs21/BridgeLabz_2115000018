package org.example;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToStudentExample {
    public static void main(String[] args) {
        String filePath = "src/main/resources/students.csv";
        List<Student> students = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read all records from the CSV file
            List<String[]> records = reader.readAll();

            // Skip the header row (assumed to be at index 0)
            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                int id = Integer.parseInt(row[0]);
                String name = row[1];
                int age = Integer.parseInt(row[2]);
                double marks = Double.parseDouble(row[3]);

                // Create a Student object and add it to the list
                Student student = new Student(id, name, age, marks);
                students.add(student);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        // Print all Student objects
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

