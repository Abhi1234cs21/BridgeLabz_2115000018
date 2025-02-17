import java.util.*;

public class SearchComparison1 {
    public static void main(String[] args) {
        int N = 1_000_000;
        int searchElement = N / 2;
        
        int[] array = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        
        for (int i = 0; i < N; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }
        
        long startTime = System.nanoTime();
        boolean foundArray = linearSearch(array, searchElement);
        long endTime = System.nanoTime();
        System.out.println("Array search time: " + (endTime - startTime) / 1e6 + " ms");
        
        startTime = System.nanoTime();
        boolean foundHashSet = hashSet.contains(searchElement);
        endTime = System.nanoTime();
        System.out.println("HashSet search time: " + (endTime - startTime) / 1e6 + " ms");
        
        startTime = System.nanoTime();
        boolean foundTreeSet = treeSet.contains(searchElement);
        endTime = System.nanoTime();
        System.out.println("TreeSet search time: " + (endTime - startTime) / 1e6 + " ms");
    }
    
    public static boolean linearSearch(int[] array, int target) {
        for (int num : array) {
            if (num == target) return true;
        }
        return false;
    }
}