package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        // Database credentials
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "root";
        String password = "password";

        // Query to fetch data
        String query = "SELECT id, name, age, email FROM users";

        // List to store records
        List<Map<String, Object>> userList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Fetch each row and store it in a Map
            while (rs.next()) {
                Map<String, Object> user = new HashMap<>();
                user.put("id", rs.getInt("id"));
                user.put("name", rs.getString("name"));
                user.put("age", rs.getInt("age"));
                user.put("email", rs.getString("email"));
                userList.add(user);
            }

            // Convert list to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userList);

            // Print JSON
            System.out.println("✅ JSON Report:\n" + json);

            // Save JSON to file
            File jsonFile = new File("src/main/resources/report.json");
            try (FileWriter fileWriter = new FileWriter(jsonFile)) {
                fileWriter.write(json);
                System.out.println("✅ JSON report saved at: " + jsonFile.getAbsolutePath());
            }

        } catch (SQLException | IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}

