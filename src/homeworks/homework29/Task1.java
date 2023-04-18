package homeworks.homework29;

public class Task1 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 6, 2};
        System.out.println(findNextLargest(arr1, 2));

        int[] arr2 = new int[]{5, 1, 4, 2};
        System.out.println(findNextLargest(arr2, 2));

        int[] arr3 = new int[]{5, 1, 4, 2};
        System.out.println(findNextLargest(arr3, 5));
    }

    public static Integer findNextLargest(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            throw new NullPointerException("Array cannot be null or empty.");
        }

        Integer result = null;
        for (int num : arr) {
            if (num > n && (result == null || num < result)) {
                result = num;
            }
        }
        return result;
    }
}
