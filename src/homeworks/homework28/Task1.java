package homeworks.homework28;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 2, 1, 5, 4, 2, 1, 7, 8, 9, 2, 3, 4, 1, 6, 4, 2, 7, 9};
        System.out.println(benchmark(20, () -> Arrays.sort(a)));
    }

    public static long benchmark(int repetitionsCount, Runnable action) {
        if (repetitionsCount < 0) {
            return -1;
        }

        if (action == null) {
            return -1;
        }

        long startTime = System.nanoTime();

        for (int i = 0; i < repetitionsCount; i++) {
            action.run();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime);
    }
}
