import java.io.*;

public class WordCountInFile {
    public static void main(String[] args) {
        String filePath = "example.txt"; // Specify your file path
        String targetWord = "Java"; // Word to search for
        int wordCount = 0;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into words using space and punctuation as delimiters
                String[] words = line.split("\\W+");

                // Count occurrences of the target word (case-sensitive)
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        wordCount++;
                    }
                }
            }

            System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");
            
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
