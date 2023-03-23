package tests.test4;

public class Task2 {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 3, 4, 5};
        System.out.println(findMissingNumber(array1));

        int[] array2 = new int[]{3, 1, 5, 4};
        System.out.println(findMissingNumber(array2));

        int[] array3 = new int[]{1, 0, -2, 3, 2};
        System.out.println(findMissingNumber(array3));

        try {
            int[] array4 = new int[]{};
            System.out.println(findMissingNumber(array4));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int findMissingNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("The array must not be empty.");
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int actualSum = 0;
        for (int number : arr) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
            actualSum += number;
        }

        int expectedSum = (min + max) * (arr.length + 1) / 2;

        return expectedSum - actualSum;
    }
}
