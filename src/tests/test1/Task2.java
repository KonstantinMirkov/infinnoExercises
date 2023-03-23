package tests.test1;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {1, 3, 8, 1, 16, 3, 4};

        int[] arrayWithoutDuplicates = removeDuplicates(array);

        System.out.println(Arrays.toString(arrayWithoutDuplicates));
    }

    public static int[] removeDuplicates(int[] array) {
        int uniqueNumbersCount = 0;

        for (int i = 0; i < array.length; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < uniqueNumbersCount; j++) {
                if (array[i] == array[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                array[uniqueNumbersCount++] = array[i];
            }
        }
        return Arrays.copyOf(array, uniqueNumbersCount);
    }
}
