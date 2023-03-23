package homeworks.homework19;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int n1 = 1;
        rotate(arr1, n1);
        System.out.println(Arrays.toString(arr1)); // [3, 1, 2]

        int[] arr2 = {1, 2, 3, 4};
        int n2 = 2;
        rotate(arr2, n2);
        System.out.println(Arrays.toString(arr2)); // [3, 4, 1, 2]

        try {
            int[] arr3 = null;
            int n3 = 2;
            rotate(arr3, n3);
            System.out.println(Arrays.toString(arr3));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Array cannot be null or empty.
        }
        try {
            int[] arr4 = {1, 2, 3, 4};
            int n4 = -2;
            rotate(arr4, n4);
            System.out.println(Arrays.toString(arr4));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // The rotations count cannot be negative.
        }
    }

    public static void rotate(int[] arr, int rotationsCount) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }
        if (rotationsCount < 0) {
            throw new IllegalArgumentException("The rotations count cannot be negative.");
        }

        if (arr.length == 0) {
            return;
        }

        int len = arr.length;
        reverse(arr, 0, len - 1);
        reverse(arr, 0, rotationsCount - 1);
        reverse(arr, rotationsCount, len - 1);
    }

    public static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            arr[left] = arr[left] + arr[right];
            arr[right] = arr[left] - arr[right];
            arr[left] = arr[left] - arr[right];
            left++;
            right--;
        }
    }
}
