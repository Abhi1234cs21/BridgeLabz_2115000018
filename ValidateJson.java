package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ValidateJson {
    public static void main(String[] args) {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Load JSON file from src/main/resources
            File file = getFileFromResources("src/main/resources/data.json");

            // Read JSON file into JsonNode
            JsonNode rootNode = objectMapper.readTree(file);

            // Validate JSON structure
            if (isValidJson(rootNode)) {
                System.out.println("✅ JSON is valid!");
            } else {
                System.out.println("❌ JSON is invalid!");
            }

        } catch (IOException e) {
            System.err.println("Error reading JSON: " + e.getMessage());
        }
    }

    // Method to validate JSON structure
    private static boolean isValidJson(JsonNode node) {
        // Check if required fields exist
        return node.has("name") && node.has("email") && node.has("age")
                && node.get("name").isTextual()
                && node.get("email").isTextual()
                && node.get("age").isInt();
    }

    // Utility method to load files from src/main/resources
    private static File getFileFromResources(String fileName) {
        ClassLoader classLoader = ValidateJson.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }
        return new File(resource.getFile());
    }
}

