import java.util.*;

public class MaxValueKey {

    public static void main(String[] args) {
        // Sample input map
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);

        // Call the method to find the key with the highest value
        String keyWithMaxValue = findKeyWithMaxValue(inputMap);

        // Print the result
        System.out.println("Key with the highest value: " + keyWithMaxValue);
    }

    // Method to find the key with the maximum value
    public static String findKeyWithMaxValue(Map<String, Integer> inputMap) {
        // Initialize variables to track the key with the highest value
        String keyWithMaxValue = null;
        int maxValue = Integer.MIN_VALUE;

        // Iterate through the map to find the key with the maximum value
        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                keyWithMaxValue = entry.getKey();
            }
        }

        return keyWithMaxValue;
    }
}
