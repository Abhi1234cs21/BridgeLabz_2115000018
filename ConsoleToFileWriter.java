import java.io.*;

public class ConsoleToFileWriter {
    public static void main(String[] args) {
        String filePath = "output.txt"; // File to write user input

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(filePath, true); // Append mode
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            
            System.out.println("Enter text (type 'exit' to stop):");

            String userInput;
            while (!(userInput = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(userInput);
                bufferedWriter.newLine(); // Write a new line
            }

            System.out.println("User input has been saved to " + filePath);
            
        } catch (IOException e) {
            System.err.println("Error handling file: " + e.getMessage());
        }
    }
}
