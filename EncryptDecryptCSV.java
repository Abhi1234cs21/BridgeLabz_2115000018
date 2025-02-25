package org.example;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

public class EncryptDecryptCSV {

    // 16-byte secret key for AES (for demonstration only)
    private static final String SECRET_KEY = "0123456789abcdef";
    private static final String ALGORITHM = "AES";

    // Encrypt a plain text string and return a Base64 encoded result
    public static String encrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(input.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypt a Base64 encoded string and return the original plain text
    public static String decrypt(String encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encrypted);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes, "UTF-8");
    }

    // Write a CSV file with encrypted Email and Salary fields
    public static void writeEncryptedCSV(String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // CSV Header
            String[] header = {"ID", "Name", "Email", "Salary"};
            writer.writeNext(header);

            // Sample employee data (plain text)
            String[][] employees = {
                    {"1", "John Doe", "john.doe@example.com", "50000"},
                    {"2", "Jane Smith", "jane.smith@example.com", "60000"},
                    {"3", "Bob Johnson", "bob.johnson@example.com", "55000"}
            };

            // Encrypt sensitive fields and write each record
            for (String[] employee : employees) {
                String encryptedEmail = encrypt(employee[2]);
                String encryptedSalary = encrypt(employee[3]);
                String[] record = {employee[0], employee[1], encryptedEmail, encryptedSalary};
                writer.writeNext(record);
            }
            System.out.println("Encrypted CSV file written successfully at: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read the CSV file, decrypt sensitive fields, and display the data
    public static void readDecryptedCSV(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read header (skip or use as needed)
            String[] header = reader.readNext();

            String[] record;
            while ((record = reader.readNext()) != null) {
                // Decrypt the Email and Salary fields (assumed to be at index 2 and 3)
                String decryptedEmail = decrypt(record[2]);
                String decryptedSalary = decrypt(record[3]);

                System.out.println("ID: " + record[0]);
                System.out.println("Name: " + record[1]);
                System.out.println("Email: " + decryptedEmail);
                System.out.println("Salary: " + decryptedSalary);
                System.out.println("--------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main method to demonstrate writing and reading the encrypted CSV file
    public static void main(String[] args) {
        String filePath = "src/main/resources/encrypted_employees.csv";

        // Write the CSV file with encrypted data
        writeEncryptedCSV(filePath);

        // Read and decrypt the CSV file
        readDecryptedCSV(filePath);
    }
}

