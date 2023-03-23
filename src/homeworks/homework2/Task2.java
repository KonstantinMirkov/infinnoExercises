package homeworks.homework2;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {2, -1, 8, -2};

        int[] currentSum = currentSum(array);

        System.out.println(Arrays.toString(currentSum));
    }
    public static int[] currentSum(int[] array) {
        int[] result = new int[array.length];
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            result[i] = sum;
        }

        return result;
    }
}