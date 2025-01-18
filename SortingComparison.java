
import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    public static void main(String[] args) {
        int size = 10000;
        int[] array = generateRandomArray(size);

        long startTime = System.currentTimeMillis();
        insertionSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Insertion sort time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        selectionSort(array);
        endTime = System.currentTimeMillis();
        System.out.println("Selection sort time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        Arrays.sort(array);
        endTime = System.currentTimeMillis();
        System.out.println("Arrays sort time: " + (endTime - startTime) + " ms");
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
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
