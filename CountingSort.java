import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of students:");
        int n = scanner.nextInt();
        
        int[] ages = new int[n];
        
        System.out.println("Enter the ages of the students (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }
        
        countingSort(ages);
        
        System.out.println("Sorted ages:");
        System.out.println(Arrays.toString(ages));
        
        scanner.close();
    }

    public static void countingSort(int[] arr) {
        int maxAge = 18;
        int minAge = 10;
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - minAge]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - minAge] - 1] = arr[i];
            count[arr[i] - minAge]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
