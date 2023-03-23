package homeworks.homework2;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        reverseArray(array);

        System.out.println(Arrays.toString(array));
    }

    public static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            array[start] = array[start] + array[end];
            array[end] = array[start] - array[end];
            array[start] = array[start] - array[end];

            start++;
            end--;
        }
    }
}