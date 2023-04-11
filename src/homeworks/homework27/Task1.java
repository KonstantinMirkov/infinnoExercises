package homeworks.homework27;

import java.util.HashMap;
import java.util.Objects;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 3, 7, 9, 5, 3, 7};
        System.out.println(mostFrequent(arr)); // 3

        int[] arr2 = new int[]{2, 1, 2, 1};
        System.out.println(mostFrequent(arr2)); // 1

        try {
            int[] arr3 = new int[]{};
            System.out.println(mostFrequent(arr3));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage()); // Array cannot be null or empty.
        }
    }

    public static int mostFrequent(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new NullPointerException("Array cannot be null or empty.");
        }

        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int mostFrequent = arr[0];
        for (int key : countMap.keySet()) {
            if (countMap.get(key) > countMap.get(mostFrequent) ||
                Objects.equals(countMap.get(key), countMap.get(mostFrequent)) && key < mostFrequent) {
                mostFrequent = key;
            }
        }
        return mostFrequent;
    }
}
