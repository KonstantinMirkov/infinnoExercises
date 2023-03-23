package tests.test1;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] array = {1, 8, 0, 6, 3};
        int largestNumbersLimit = 3;

        int[] largestNumbersArray = findLargestNumbers(array, largestNumbersLimit);

        System.out.println(Arrays.toString(largestNumbersArray));
    }

    public static int[] findLargestNumbers(int[] array, int largestNumbersLimit) {
        int[] result = new int[largestNumbersLimit];

        for (int i = 0; i < largestNumbersLimit; i++) {
            int maxNum = array[0];
            int maxNumIndex = 0;

            for (int j = 1; j < array.length; j++) {
                if (array[j] > maxNum) {
                    maxNum = array[j];
                    maxNumIndex = j;
                }
            }
            result[i] = maxNum;
            array[maxNumIndex] = Integer.MIN_VALUE;
        }
        return result;
    }
}
