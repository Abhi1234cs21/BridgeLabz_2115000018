import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();
        
        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) data[i] = rand.nextInt(size * 10);
            
            int[] dataCopy = Arrays.copyOf(data, data.length);
            long startTime = System.nanoTime();
            bubbleSort(dataCopy);
            long endTime = System.nanoTime();
            System.out.println("Bubble Sort for N = " + size + ": " + (endTime - startTime) / 1e6 + " ms");
            
            dataCopy = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            mergeSort(dataCopy, 0, dataCopy.length - 1);
            endTime = System.nanoTime();
            System.out.println("Merge Sort for N = " + size + ": " + (endTime - startTime) / 1e6 + " ms");
            
            dataCopy = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            quickSort(dataCopy, 0, dataCopy.length - 1);
            endTime = System.nanoTime();
            System.out.println("Quick Sort for N = " + size + ": " + (endTime - startTime) / 1e6 + " ms");
			
			System.out.println(" ");
        }
		
    }
}