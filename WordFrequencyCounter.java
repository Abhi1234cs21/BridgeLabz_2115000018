import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        // Replace with the path to your input text file
        String filePath = "input.txt";
        
        // Call the method to read the file and count word frequencies
        Map<String, Integer> wordCounts = countWordFrequency(filePath);
        
        // Print the results
        System.out.println(wordCounts);
    }
    
    // Method to count word frequencies from a file
    public static Map<String, Integer> countWordFrequency(String filePath) {
        // Initialize a HashMap to store the word frequencies
        Map<String, Integer> wordCountMap = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                // Remove punctuation and convert the line to lowercase
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                
                // Split the line into words based on spaces
                String[] words = line.split("\\s+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        // Update the word count in the map
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return wordCountMap;
    }
}
