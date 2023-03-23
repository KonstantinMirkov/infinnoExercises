package homeworks.homework5;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3};
        int[] result = subArray(array, 2);
        System.out.println(Arrays.toString(result));

        int[] array2 = {1, 2, 3, 4, 3};
        result = subArray(array2, 2, 3);
        System.out.println(Arrays.toString(result));
    }

    public static int[] subArray(int[] array, int start) {
        int arrLength = array.length;
        int[] result = new int[arrLength - start];

        for (int i = start; i < arrLength; i++) {
            result[i - start] = array[i];
        }

        return result;
    }

    public static int[] subArray(int[] array, int start, int end) {
        int[] result = new int[end - start + 1];

        for (int i = start; i <= end; i++) {
            result[i - start] = array[i];
        }

        return result;
    }
}
