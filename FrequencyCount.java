import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCount {
    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "apple", "orange");

        Map<String, Integer> frequencyMap = countFrequency(strings);

        System.out.println(frequencyMap);
    }

    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : list) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }
        return frequencyMap;
    }
}
