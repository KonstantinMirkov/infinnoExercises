package tests.test4a;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 5, 3, 7, 9, 5, 3, 7};
        System.out.println(Arrays.toString(frequencySort(arr1))); // [3, 3, 3, 5, 5, 7, 7, 2, 9]

        int[] arr2 = {2, 1, 2};
        System.out.println(Arrays.toString(frequencySort(arr2))); // [2, 2, 1]

        int[] arr3 = {2, 1, 2, 1};
        System.out.println(Arrays.toString(frequencySort(arr3))); // [1, 1, 2, 2]

        try {
            int[] arr4 = {200, -1, 2, 1};
            System.out.println(Arrays.toString(frequencySort(arr4)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Numbers cannot be lower than 0 and higher than 100.
        }

        try {
            int[] arr5 = {};
            System.out.println(Arrays.toString(frequencySort(arr5)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Array cannot be null or empty.
        }
    }

    public static int[] frequencySort(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : array) {
            if (num < 0 || num > 100) {
                throw new IllegalArgumentException("Numbers cannot be lower than 0 and higher than 100.");
            }

            Integer count = frequencyMap.get(num);
            if (count == null) {
                count = 0;
            }

            frequencyMap.put(num, count + 1);
        }

        Comparator<Integer> frequencyComparator = (a, b) -> {
            int f1 = frequencyMap.get(a);
            int f2 = frequencyMap.get(b);
            return f1 == f2 ? Integer.compare(frequencyMap.get(a), frequencyMap.get(b)) : Integer.compare(f1, f2);
        };

        Queue<Integer> heap = new PriorityQueue<>(frequencyComparator);
        for (int num : frequencyMap.keySet()) {
            heap.offer(num);
        }

        int[] sortedArr = new int[array.length];
        int index = 0;
        while (!heap.isEmpty()) {
            int num = heap.poll();
            int count = frequencyMap.get(num);
            for (int i = 0; i < count; i++) {
                sortedArr[index++] = num;
            }
        }

        return sortedArr;
    }
}
