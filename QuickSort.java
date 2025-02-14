import java.util.*;

class QuickSort {

    void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    int partition(double[] arr, int low, int high) {
        double pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("No products in array.");
        } else {
            double[] productPrices = new double[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the price of Product " + (i + 1) + ": ");
                productPrices[i] = sc.nextDouble();
            }
            qs.quickSort(productPrices, 0, n - 1);
            System.out.print("Product Prices in ascending order: ");
            for (int i = 0; i < n; i++) {
                System.out.print(productPrices[i] + " ");
            }
        }
    }
}
