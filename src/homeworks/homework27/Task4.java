package homeworks.homework27;

import java.util.ArrayList;
import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 8, 1, 4};
        sortOdds(arr);
        System.out.println(Arrays.toString(arr)); // 1, 3, 2, 8, 5, 4

        try {
            int[] arr2 = new int[]{};
            sortOdds(arr2);
            System.out.println(Arrays.toString(arr2));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage()); // Array cannot be null or empty.
        }
    }

    public static void sortOdds(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new NullPointerException("Array cannot be null or empty.");
        }

        ArrayList<Integer> odds = new ArrayList<>();
        for (int num : arr) {
            if (num % 2 != 0) {
                odds.add(num);
            }
        }
        for (int i = 1; i < odds.size(); i++) {
            int j = i;
            while (j > 0 && odds.get(j - 1) > odds.get(j)) {
                int temp = odds.get(j);
                odds.set(j, odds.get(j - 1));
                odds.set(j - 1, temp);
                j--;
            }
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arr[i] = odds.get(index);
                index++;
            }
        }
    }
}
