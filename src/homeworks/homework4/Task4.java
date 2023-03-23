package homeworks.homework4;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 0, 12};
        int value = 8;

        int[] shiftedArray = unShiftArray(array, value);

        System.out.println(Arrays.toString(shiftedArray));
    }

    public static int[] unShiftArray(int[] array, int value) {
        int[] result = new int[array.length + 1];
        result[0] = value;

        System.arraycopy(array, 0, result, 1, array.length);

        return result;
    }
}
