package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeCSVFiles {
    public static void main(String[] args) {
        // Define file paths
        String file1Path = "src/main/resources/student1.csv";
        String file2Path = "src/main/resources/student2.csv";
        String outputFilePath = "src/main/resources/merged_students.csv";

        // Map to store rows from students1.csv keyed by ID
        Map<String, String[]> studentInfoMap = new HashMap<>();

        // Read students1.csv and store records in the map
        try (CSVReader reader1 = new CSVReader(new FileReader(file1Path))) {
            List<String[]> records1 = reader1.readAll();
            // Skip header (first row)
            for (int i = 1; i < records1.size(); i++) {
                String[] row = records1.get(i);
                // row[0] is ID
                studentInfoMap.put(row[0], row);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        // Now read students2.csv, merge with data from students1.csv, and write output
        try (CSVReader reader2 = new CSVReader(new FileReader(file2Path));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

            List<String[]> records2 = reader2.readAll();
            // Write merged header: combine headers from both files (skip duplicate ID in second file)
            String[] mergedHeader = {"ID", "Name", "Age", "Marks", "Grade"};
            writer.writeNext(mergedHeader);

            // Skip header in students2.csv (first row) and process the rest
            for (int i = 1; i < records2.size(); i++) {
                String[] row2 = records2.get(i);
                String id = row2[0];
                // Look up the corresponding row in students1.csv
                String[] row1 = studentInfoMap.get(id);
                if (row1 != null) {
                    // Merge the rows:
                    // row1: [ID, Name, Age]
                    // row2: [ID, Marks, Grade]
                    String[] mergedRow = {id, row1[1], row1[2], row2[1], row2[2]};
                    writer.writeNext(mergedRow);
                } else {
                    // If no match is found, you could either skip or log a message.
                    System.out.println("No matching record found in students1.csv for ID: " + id);
                }
            }
            System.out.println("Merged CSV file created at: " + outputFilePath);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}

