package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class ConvertListToJson {
    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> people = Arrays.asList(
                new Person("Alice", 25, "alice@example.com"),
                new Person("Bob", 30, "bob@example.com"),
                new Person("Charlie", 28, "charlie@example.com")
        );

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Convert list to JSON string
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(people);

            // Print JSON output
            System.out.println(jsonArray);

            // Save JSON to file in src/main/resources
            File file = new File("src/main/resources/persons.json");
            objectMapper.writeValue(file, people);
            System.out.println("✅ JSON array saved to: " + file.getAbsolutePath());

            // Validate JSON after saving
            if (validateJsonStructure(file)) {
                System.out.println("✅ JSON is valid!");
            } else {
                System.out.println("❌ JSON is invalid!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Person class
    static class Person {
        @JsonProperty("name")
        private String name;

        @JsonProperty("age")
        private int age;

        @JsonProperty("email")
        private String email;

        // Constructor
        public Person(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }
    }

    // Validate JSON structure
    private static boolean validateJsonStructure(File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(file);
            for (JsonNode node : rootNode) {
                if (!node.has("name") || !node.has("age") || !node.has("email")) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
