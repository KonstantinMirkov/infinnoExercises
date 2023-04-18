package homeworks.homework29;

public class Task2 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 5, 12, 25};

        int idx = find(a, 5);
        System.out.println(idx);// 2

        idx = find(a, 0);
        System.out.println(idx);// -1
    }

    public static int find(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            throw new NullPointerException("Array cannot be null or empty.");
        }

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}