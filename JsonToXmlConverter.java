package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        File jsonFile = new File("src/main/resources/data.json");
        File xmlFile = new File("src/main/resources/data.xml");

        try {
            // Create ObjectMapper for JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonFile);

            // Convert JSON to XML
            XmlMapper xmlMapper = new XmlMapper();
            String xmlContent = xmlMapper.writeValueAsString(jsonNode);

            // Print XML output
            System.out.println("✅ XML Output:\n" + xmlContent);

            // Save XML to file
            xmlMapper.writeValue(xmlFile, jsonNode);
            System.out.println("✅ XML file saved at: " + xmlFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}

