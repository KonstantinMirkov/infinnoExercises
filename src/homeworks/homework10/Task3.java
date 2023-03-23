package homeworks.homework10;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        char[] array = {'a', 'b', 'c'};
        char[] reversed = reverse(array);
        System.out.println(Arrays.toString(reversed));  // [c, b, a]

        char[] array2 = {'1', '2', '3'};
        char[] reversed2 = reverse(array2);
        System.out.println(Arrays.toString(reversed2));  // [3, 2, 1]
    }

    public static char[] reverse(char[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            array[i] = (char) (array[i] + array[j]);
            array[j] = (char) (array[i] - array[j]);
            array[i] = (char) (array[i] - array[j]);
            i++;
            j--;
        }
        return array;
    }
}
