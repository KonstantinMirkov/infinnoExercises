package tests.test6;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = {0, 5, 1, 2, 3, 4, 5, 2, 8, 9, 10};
        int[] result = longestConsecutiveSequence(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] longestConsecutiveSequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int start = 0;
        int end = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                end = i;
            } else {
                if (end - start > maxEnd - maxStart) {
                    maxStart = start;
                    maxEnd = end;
                }
                start = i;
                end = i;
            }
        }

        int[] result = new int[maxEnd - maxStart + 1];
        for (int i = maxStart; i <= maxEnd; i++) {
            result[i - maxStart] = arr[i];
        }
        return result;
    }
}
