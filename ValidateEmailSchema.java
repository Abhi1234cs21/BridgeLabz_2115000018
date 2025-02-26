package org.example;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ValidateEmailSchema {
   public static void main(String[] args) {
       File schemaFile = new File("src/main/resources/email-schema.json");
       File jsonFile = new File("src/main/resources/user.json");

       try {
           // Load JSON Schema
           Schema schema = SchemaLoader.load(new JSONObject(new JSONTokener(new FileInputStream(schemaFile))));

           // Load JSON Data
           JSONObject jsonData = new JSONObject(new JSONTokener(new FileInputStream(jsonFile)));

           // Validate JSON
           schema.validate(jsonData);
           System.out.println("✅ JSON is valid!");

       } catch (Exception e) {
           System.out.println("❌ JSON validation failed: " + e.getMessage());
       }
   }
}