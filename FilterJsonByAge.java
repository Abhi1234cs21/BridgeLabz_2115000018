package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FilterJsonByAge {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        File inputFile = new File("src/main/resources/persons.json");
        File outputFile = new File("src/main/resources/filtered_persons.json");

        try {
            // Read JSON file and parse into a list of Person objects
            List<Person> people = objectMapper.readValue(inputFile, new TypeReference<List<Person>>() {});

            // Filter only those records where age > 25
            List<Person> filteredPeople = people.stream()
                    .filter(person -> person.getAge() > 25)
                    .collect(Collectors.toList());

            // Print filtered data
            System.out.println("Filtered Records (age > 25):");
            filteredPeople.forEach(System.out::println);

            // Save filtered data to a new JSON file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, filteredPeople);
            System.out.println("✅ Filtered JSON saved to: " + outputFile.getAbsolutePath());

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
        public Person() {}

        public String getName() { return name; }
        public int getAge() { return age; }
        public String getEmail() { return email; }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
        }
    }
}

