package tests.test9;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 2};
        sortArray(arr);
        System.out.println(Arrays.toString(arr)); // 1, 2, 3, 4, 5

        int[] arr2 = {};
        sortArray(arr2);
        System.out.println(Arrays.toString(arr2));
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
}
