package homeworks.homework28;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task3 {
    public static void main(String[] args) {
        int[] pair = new int[]{1, 2, 5, -1};
        System.out.println(Arrays.toString(findSumElements(pair, 0))); // -1, 1]

        int[] pair2 = new int[]{1, 2, 5, -1};
        System.out.println(Arrays.toString(findSumElements(pair2, 1))); // [-1, 2]

        int[] pair3 = new int[]{1, 2, 5, -1};
        System.out.println(Arrays.toString(findSumElements(pair3 ,2))); // null
    }

    public static int[] findSumElements(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            throw new NullPointerException("Array cannot be null or empty.");
        }

        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            int difference = target - num;
            if (set.contains(difference)) {
                return new int[]{num, difference};
            }
            set.add(num);
        }
        return null;
    }
}
