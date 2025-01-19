
import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    public static void main(String[] args) {
        int size = 10000;
        int[] array = generateRandomArray(size);

        int[] insertionSortArray = Arrays.copyOf(array, array.length);
        long startTime = System.nanoTime();
        insertionSort(insertionSortArray);
        long endTime = System.nanoTime();
        System.out.println("Insertion sort time: " + (endTime - startTime) + " ns");
        System.out.println("Insertion sort correct: " + sorted(insertionSortArray));
        printElements(insertionSortArray);

        int[] selectionSortArray = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        selectionSort(selectionSortArray);
        endTime = System.nanoTime();
        System.out.println("Selection sort time: " + (endTime - startTime) + " ns");
        System.out.println("Selection sort correct: " + sorted(selectionSortArray));
        printElements(selectionSortArray);

        int[] quickSortArray = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        quickSort(quickSortArray, 0, quickSortArray.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick sort time: " + (endTime - startTime) + " ns");
        System.out.println("Quick sort correct: " + sorted(quickSortArray));
        printElements(quickSortArray);

        int[] arraySortArray = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        Arrays.sort(arraySortArray);
        endTime = System.nanoTime();
        System.out.println("Arrays sort time: " + (endTime - startTime) + " ns");
        System.out.println("Arrays sort correct: " + sorted(arraySortArray));
        printElements(arraySortArray);
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

    public static void selectionSort(int[] array) {
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

    public static boolean sorted(int[] arr) {
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

}
