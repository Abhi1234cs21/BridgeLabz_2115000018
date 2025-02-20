import java.util.*;

public class MergeMaps {

    public static void main(String[] args) {
        // Sample input maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        
        // Call the method to merge the two maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);
        
        // Print the merged result
        System.out.println("Merged Map: " + mergedMap);
    }

    // Method to merge two maps
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        // Create a new map to store the merged result
        Map<String, Integer> mergedMap = new HashMap<>(map1);
        
        // Iterate through the second map and add values to the merged map
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            // If the key is already in the merged map, sum the values
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        
        return mergedMap;
    }
}
