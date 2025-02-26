package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonAndPrintKeys {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("src/main/resources/data.json");

        try {
            // Read JSON file into JsonNode
            JsonNode rootNode = objectMapper.readTree(jsonFile);

            // Print all keys and values
            System.out.println("JSON Contents:");
            printJsonKeysAndValues(rootNode, "");

        } catch (IOException e) {
            System.out.println("❌ Error reading JSON file: " + e.getMessage());
        }
    }

    // Recursive method to print keys and values
    private static void printJsonKeysAndValues(JsonNode node, String parentKey) {
        if (node.isObject()) {
            // Iterate through object fields
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                printJsonKeysAndValues(field.getValue(), parentKey + field.getKey() + ".");
            }
        } else if (node.isArray()) {
            // Iterate through array elements
            for (int i = 0; i < node.size(); i++) {
                printJsonKeysAndValues(node.get(i), parentKey + "[" + i + "].");
            }
        } else {
            // Print key and value
            System.out.println(parentKey.substring(0, parentKey.length() - 1) + " = " + node.asText());
        }
    }
}

