package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicatesInCSV {
    public static void main(String[] args) {
        // Path to your CSV file
        String filePath = "src/main/resources/data.csv";

        // Map to store rows based on ID
        Map<String, List<String[]>> recordMap = new LinkedHashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            // Check if file has data (excluding header)
            if (records.size() <= 1) {
                System.out.println("No data records found in CSV.");
                return;
            }

            // Assume first row is the header
            String[] header = records.get(0);

            // Process each row (skip header row)
            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                String id = row[0].trim(); // Assuming the first column is ID
                recordMap.computeIfAbsent(id, k -> new ArrayList<>()).add(row);
            }

            // Detect and print duplicate records
            boolean duplicatesFound = false;
            for (Map.Entry<String, List<String[]>> entry : recordMap.entrySet()) {
                List<String[]> duplicateList = entry.getValue();
                if (duplicateList.size() > 1) {
                    duplicatesFound = true;
                    System.out.println("Duplicate records for ID: " + entry.getKey());
                    for (String[] dupRow : duplicateList) {
                        System.out.println(Arrays.toString(dupRow));
                    }
                    System.out.println();
                }
            }

            if (!duplicatesFound) {
                System.out.println("No duplicate records found based on ID.");
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}


