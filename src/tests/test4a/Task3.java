package tests.test4a;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] arr1 = {3, 12, 5, 12, 8, 5};
        System.out.println(Arrays.toString(removeDuplicates(arr1))); // [3, 12, 5, 8]

        int[] arr2 = {1, 2, 3, 2, 1};
        System.out.println(Arrays.toString(removeDuplicates(arr2))); // [1, 2, 3]

        try {
            int[] arr3 = {};
            System.out.println(Arrays.toString(removeDuplicates(arr3)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Array cannot be null or empty.
        }
    }

    public static int[] removeDuplicates(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        int[] result = new int[array.length];
        int index = 0;

        for (int num : array) {

            boolean isDuplicate = false;
            for (int j = 0; j < index; j++) {
                if (num == result[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                result[index++] = num;
            }
        }

        return Arrays.copyOf(result, index);
    }
}
