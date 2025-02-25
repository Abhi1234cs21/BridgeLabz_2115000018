package org.example;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenerateCSVReport {

    public static void main(String[] args) {
        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database"; // Replace with your DB URL
        String username = "your_username"; // Replace with your DB username
        String password = "your_password"; // Replace with your DB password

        // Path where the CSV file will be generated
        String csvFilePath = "src/main/resources/employee_report.csv";

        // SQL query to fetch employee records
        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (
                // Establish database connection
                Connection connection = DriverManager.getConnection(jdbcURL, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                // Create CSVWriter to write the report
                CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))
        ) {
            // Write CSV header
            String[] header = {"Employee ID", "Name", "Department", "Salary"};
            writer.writeNext(header);

            // Process the ResultSet and write each record to CSV
            while (resultSet.next()) {
                String employeeId = resultSet.getString("employee_id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                String salary = resultSet.getString("salary");
                String[] record = {employeeId, name, department, salary};
                writer.writeNext(record);
            }

            System.out.println("CSV report generated successfully at: " + csvFilePath);

        } catch (SQLException e) {
            System.err.println("Database error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("File writing error:");
            e.printStackTrace();
        }
    }
}

