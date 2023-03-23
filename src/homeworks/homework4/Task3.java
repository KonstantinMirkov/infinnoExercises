package homeworks.homework4;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 0, 12};

        int firstElement = removeFirst(array);

        System.out.println(firstElement);
        System.out.println(Arrays.toString(array));
    }

    public static int removeFirst(int[] array) {
        if (array.length == 0) {
            return Integer.MIN_VALUE;
        }

        int firstElement = array[0];

        System.arraycopy(array, 1, array, 0, array.length - 1);

        array[array.length - 1] = Integer.MIN_VALUE;

        return firstElement;
    }
}
