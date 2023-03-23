package homeworks.homework1;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] array = {1, 3, 1, 2, 5, 2, 1, 3};

        arraySort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void arraySort(int[] array) {
        int[] counts = new int[6];

        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }

        int count = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < counts[i]; j++) {
                array[count++] = i;
            }
        }
    }
}