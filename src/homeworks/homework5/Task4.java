package homeworks.homework5;


import java.util.HashSet;
import java.util.Set;

public class Task4 {
    public static void main(String[] args) {
        int[] array1 = {1, 1, 2, 3};
        int[] array2 = {1, 2, 2, 2, 3};
        boolean result = sameNumbers(array1, array2);
        System.out.println(result);

        int[] array3 = {1, 2, 3, 3, 3};
        int[] array4 = {2, 2, 2, 4};
        result = sameNumbers(array3, array4);
        System.out.println(result);
    }

    public static boolean sameNumbers(int[] array1, int[] array2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : array1) {
            set1.add(i);
        }

        for (int i : array2) {
            set2.add(i);
        }

        return set1.equals(set2);
    }
}
