package homeworks.homework28;

public class Task4 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 6};
        System.out.println(findLargest(arr)); // 6

        int[] arr2 = new int[]{1, 2, 4, 5};
        System.out.println(findLargest(arr2)); // null
    }

    public static Integer findLargest(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new NullPointerException("Array cannot be null or empty.");
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        if (max1 >= (max2 * 2)) {
            return max1;
        } else {
            return null;
        }
    }
}
