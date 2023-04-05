package homeworks.homework24;

public class Task4 {
    public static void main(String[] args) {
        int[] test1 = {1, 3, 2, 9, 17};
        System.out.println(secondLargest(test1)); // 9
        int[] test2 = {1, 1, 1};
        System.out.println(secondLargest(test2)); // -1
        int[] test3 = {1, 1, 0, 23, 1, 2};
        System.out.println(secondLargest(test3)); // 2
    }

    public static int secondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num < max) {
                secondMax = num;
            }
        }
        return secondMax == Integer.MIN_VALUE ? -1 : secondMax;
    }
}
