import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();
        
        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) data[i] = rand.nextInt(size * 10);
            int target = data[rand.nextInt(size)];
            
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long endTime = System.nanoTime();
            System.out.println("Linear Search for N = " + size + ": " + (endTime - startTime) / 1e6 + " ms");
            
            Arrays.sort(data);
            startTime = System.nanoTime();
            binarySearch(data, target);
            endTime = System.nanoTime();
            System.out.println("Binary Search for N = " + size + ": " + (endTime - startTime) / 1e6 + " ms");
        }
    }
}