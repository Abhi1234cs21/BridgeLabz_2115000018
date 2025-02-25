package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public class CSVValidationExample {
    public static void main(String[] args) {
        // Define the path to your CSV file
        String filePath = "src/main/resources/newData.csv";

        // Define regex patterns for Email and Phone Number
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        String phoneRegex = "^\\d{10}$"; // Exactly 10 digits
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            if (records.size() <= 1) {
                System.out.println("No data records found in CSV.");
                return;
            }

            // Extract header row and determine the index for Email and Phone columns
            String[] header = records.get(0);
            int emailIndex = -1;
            int phoneIndex = -1;

            for (int i = 0; i < header.length; i++) {
                if ("Email".equalsIgnoreCase(header[i])) {
                    emailIndex = i;
                }
                if ("Phone".equalsIgnoreCase(header[i]) || "Phone Numbers".equalsIgnoreCase(header[i])) {
                    phoneIndex = i;
                }
            }

            // Check if required columns are present
            if (emailIndex == -1 || phoneIndex == -1) {
                System.out.println("CSV header must include 'Email' and 'Phone' columns.");
                return;
            }

            // Validate each record (skipping header)
            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                boolean isValid = true;
                StringBuilder errorMsg = new StringBuilder("Row " + (i + 1) + " invalid: ");

                String email = row[emailIndex];
                String phone = row[phoneIndex];

                // Validate Email
                if (!emailPattern.matcher(email).matches()) {
                    isValid = false;
                    errorMsg.append("Invalid email format. ");
                }

                // Validate Phone (exactly 10 digits)
                if (!phonePattern.matcher(phone).matches()) {
                    isValid = false;
                    errorMsg.append("Phone number must contain exactly 10 digits. ");
                }

                // Print error message for invalid rows
                if (!isValid) {
                    System.out.println(errorMsg.toString());
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}

