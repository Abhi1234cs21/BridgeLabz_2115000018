import java.util.*;

public class InvertMap {

    public static void main(String[] args) {
        // Sample input map
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);
        
        // Call the method to invert the map
        Map<Integer, List<String>> invertedMap = invertMap(inputMap);
        
        // Print the inverted map
        System.out.println(invertedMap);
    }

    // Method to invert the map
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> inputMap) {
        // Initialize a new map to store the inverted result
        Map<V, List<K>> invertedMap = new HashMap<>();
        
        // Iterate over each entry in the original map
        for (Map.Entry<K, V> entry : inputMap.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            
            // If the value already exists in the inverted map, add the key to the list
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        
        return invertedMap;
    }
}
