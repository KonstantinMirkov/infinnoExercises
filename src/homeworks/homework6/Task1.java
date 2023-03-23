package homeworks.homework6;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 3, 4, 4, 5};

        Integer[] arrayWithoutDuplicates = removeDuplicates(array);

        System.out.println(Arrays.toString(arrayWithoutDuplicates));
    }

    public static Integer[] removeDuplicates(Integer[] array) {
        Set<Integer> uniqueSet = new HashSet<>(Arrays.asList(array));

        Integer[] uniqueArray = new Integer[uniqueSet.size()];

        int i = 0;
        for (int number : uniqueSet) {
            uniqueArray[i++] = number;
        }

        return uniqueArray;
    }
}
