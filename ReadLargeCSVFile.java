package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadLargeCSVFile {
    public static void main(String[] args) {
        // Path to your large CSV file
        String filePath = "src/main/resources/largefile.csv";
        int batchSize = 100; // Process 100 lines at a time
        int processedCount = 0;
        List<String[]> chunk = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Optionally, read and process the header row if needed:
            // String[] header = reader.readNext();

            String[] line;
            while ((line = reader.readNext()) != null) {
                chunk.add(line);

                // Once we have collected batchSize lines, process the chunk
                if (chunk.size() == batchSize) {
                    processedCount += chunk.size();
                    System.out.println("Processed " + processedCount + " records so far.");

                    // Here you can process the chunk as required
                    // For this example, we just clear the chunk for the next batch
                    chunk.clear();
                }
            }

            // Process any remaining records (if less than batchSize)
            if (!chunk.isEmpty()) {
                processedCount += chunk.size();
                System.out.println("Processed " + processedCount + " records in total.");
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}

