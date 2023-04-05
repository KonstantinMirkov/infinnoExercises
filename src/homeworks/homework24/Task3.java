package homeworks.homework24;

public class Task3 {
    public static void main(String[] args) {
        int num = 1234567;
        System.out.println(swapEvenDigits(num)); // 1634527
    }

    public static int swapEvenDigits(int number) {
        int[] digits = new int[10];

        int len = 0;
        while (number > 0) {
            digits[len++] = number % 10;
            number /= 10;
        }

        int left = len - 1;
        int right = 0;
        while (left > right) {
            while (left > right && digits[left] % 2 != 0 && digits[right] % 2 != 0) {
                left--;
                right++;
            }

            if (left > right) {
                digits[left] = digits[left] + digits[right];
                digits[right] = digits[left] - digits[right];
                digits[left] = digits[left] - digits[right];
                left--;
                right++;
            }
        }

        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            result = result * 10 + digits[i];
        }
        return result;
    }
}
