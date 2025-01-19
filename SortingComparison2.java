package JavaCoreCollection.Java1HW;

import java.util.Arrays;
import java.util.Random;

public class SortingComparison2 {
    public static void main(String[] args) {
        int size = 10000;
        int[] array = generateRandomArray(size);

        sortIt(array, "Insertion sort", SortingComparison2::insertionSort);
        sortIt(array, "Selection sort", SortingComparison2::selectionSort);
        sortIt(array, "Merge sort", SortingComparison2::mergeSort);
        sortIt(array, "Quick sort", (arr) -> quickSort(arr, 0, arr.length - 1));
        sortIt(array, "Arrays sort", Arrays::sort);
    }

    private static void sortIt(int[] originalArray, String sortName, SortingFunction sortFunction) {
        int[] array = Arrays.copyOf(originalArray, originalArray.length);
        long startTime = System.nanoTime();
        sortFunction.sort(array);
        long endTime = System.nanoTime();

        System.out.println(sortName + " time: " + (endTime - startTime) + " ns");
        System.out.println(sortName + " correct: " + sorted(array));
        printElements(array);
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        return array;
    }

    private static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    private static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    private static void mergeSort(int[] array) {
        if (array.length < 2) return;

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
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
            if (arr[j] <= pivot) {
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
    
    private static boolean sorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    private static void printElements(int[] array) {
        int limit = Math.min(array.length, 10);
        System.out.print("First elements: ");
        for (int i = 0; i < limit; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }

    @FunctionalInterface
    interface SortingFunction {
        void sort(int[] array);
    }
}
