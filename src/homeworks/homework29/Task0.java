package homeworks.homework29;

import java.util.Arrays;
import java.util.Random;

public class Task0 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }


        long start = System.currentTimeMillis();
        sortArray(arr.clone());
        long end = System.currentTimeMillis();
        System.out.println("Time taken by sortArray(): " + (end - start) + " ms");

        start = System.currentTimeMillis();
        Arrays.sort(arr.clone());
        end = System.currentTimeMillis();
        System.out.println("Time taken by Arrays.sort(): " + (end - start) + " ms");
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }

    public static void sortArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int minIndex = start;
            int maxIndex = start;
            for (int i = start; i <= end; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            swap(arr, start, minIndex);

            if (maxIndex == start) {
                maxIndex = minIndex;
            }

            swap(arr, end, maxIndex);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static Integer findLargest(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new NullPointerException("Array cannot be null or empty.");
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return max1 >= max2 * 2 ? max1 : null;
    }
}
