package org.example;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        File csvFile = new File("src/main/resources/data.csv");
        File jsonFile = new File("src/main/resources/data.json");

        try {
            // Create CsvMapper and Schema
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader(); // Reads headers from CSV

            // Read CSV into a List of Maps (each row as a map)
            MappingIterator<Map<String, String>> iterator = csvMapper.readerFor(Map.class)
                    .with(csvSchema)
                    .readValues(csvFile);

            List<Map<String, String>> data = iterator.readAll();

            // Convert List to JSON and Print
            ObjectMapper jsonMapper = new ObjectMapper();
            String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
            System.out.println("✅ JSON Output:\n" + json);

            // Save JSON to File
            jsonMapper.writeValue(jsonFile, data);
            System.out.println("✅ JSON file saved at: " + jsonFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}

