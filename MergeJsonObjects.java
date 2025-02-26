package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class MergeJsonObjects {
    public static void main(String[] args) {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read both JSON files into JsonNode objects
            JsonNode jsonNode1 = objectMapper.readTree(new File("src/main/resources/data1.json"));
            JsonNode jsonNode2 = objectMapper.readTree(new File("src/main/resources/data2.json"));

            // Merge two JSON objects
            ObjectNode mergedNode = objectMapper.createObjectNode();
            mergedNode.setAll((ObjectNode) jsonNode1);
            mergedNode.setAll((ObjectNode) jsonNode2);

            // Convert merged JSON to string and print
            String mergedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode);
            System.out.println("Merged JSON Object: \n" + mergedJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

