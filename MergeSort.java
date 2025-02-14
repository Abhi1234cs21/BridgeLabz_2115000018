import java.util.*;

class MergeSort {

    void merge(double[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        double[] leftArr = new double[n1];
        double[] rightArr = new double[n2];
        
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    void mergeSort(double[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    public static void main(String[] args) {
        MergeSort Ms = new MergeSort();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of Books: ");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("No Books in array.");
        } else {
            double[] bookPrices = new double[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the price of Book " + (i + 1) + ": ");
                bookPrices[i] = sc.nextDouble();
            }
            Ms.mergeSort(bookPrices, 0, n - 1);
            System.out.print("Book Prices in ascending order: ");
            for (int i = 0; i < n; i++) {
                System.out.print(bookPrices[i] + " ");
            }
        }
    }
}
