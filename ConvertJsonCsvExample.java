package org.example;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertJsonCsvExample {

    // Student class (can also be a separate file)
    public static class Student {
        private int id;
        private String name;
        private int age;
        private double marks;

        // No-args constructor required for Jackson
        public Student() {
        }

        public Student(int id, String name, int age, double marks) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.marks = marks;
        }

        // Getters and setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }

        public double getMarks() { return marks; }
        public void setMarks(double marks) { this.marks = marks; }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", marks=" + marks +
                    '}';
        }
    }

    // Method to convert JSON to CSV
    public static void convertJsonToCsv(String jsonFilePath, String csvFilePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Read JSON file into a list of Student objects
            List<Student> students = mapper.readValue(new File(jsonFilePath), new TypeReference<List<Student>>() {});

            // Create a CSVWriter
            CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath));

            // Write header
            String[] header = {"ID", "Name", "Age", "Marks"};
            writer.writeNext(header);

            // Write student records
            for (Student student : students) {
                String[] record = {
                        String.valueOf(student.getId()),
                        student.getName(),
                        String.valueOf(student.getAge()),
                        String.valueOf(student.getMarks())
                };
                writer.writeNext(record);
            }
            writer.close();
            System.out.println("JSON has been converted to CSV and saved at: " + csvFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to convert CSV back to JSON
    public static void convertCsvToJson(String csvFilePath, String jsonFilePath) {
        ObjectMapper mapper = new ObjectMapper();
        List<Student> students = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] nextLine;
            // Read header (skip or use for verification)
            String[] header = reader.readNext();

            // Process each record
            while ((nextLine = reader.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                int age = Integer.parseInt(nextLine[2]);
                double marks = Double.parseDouble(nextLine[3]);
                students.add(new Student(id, name, age, marks));
            }

            // Write the list of students back to a JSON file
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFilePath), students);
            System.out.println("CSV has been converted to JSON and saved at: " + jsonFilePath);
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    // Main method to run both conversions
    public static void main(String[] args) {
        // File paths (adjust paths as needed)
        String jsonFilePath = "src/main/resources/students.json";
        String csvFilePath = "src/main/resources/students.csv";
        String convertedJsonFilePath = "src/main/resources/students_converted.json";

        // Convert JSON to CSV
        convertJsonToCsv(jsonFilePath, csvFilePath);

        // Convert CSV back to JSON
        convertCsvToJson(csvFilePath, convertedJsonFilePath);
    }
}

