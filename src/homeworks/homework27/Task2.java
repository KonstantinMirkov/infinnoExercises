package homeworks.homework27;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 3, 8, 12, 2, 2, 2, 4, 7, 7};
        System.out.println(Arrays.toString(longestSequence(arr)));
    }

    public static int[] longestSequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new NullPointerException("Array cannot be null or empty.");
        }

        int start = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                if (i - start > maxEnd - maxStart) {
                    maxStart = start;
                    maxEnd = i;
                }
            } else {
                start = i;
            }
        }

        int[] result = new int[maxEnd - maxStart + 1];
        for (int i = maxStart; i <= maxEnd; i++) {
            result[i - maxStart] = arr[i];
        }
        return result;
    }
}
