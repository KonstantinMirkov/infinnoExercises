package homeworks.homework13;

public class Task2 {
    public static void main(String[] args) {
        int m1 = max(1);
        System.out.println(m1); // 1

        int m2 = max(1, 2, 3);
        System.out.println(m2); // 3

        int m3 = max(-5, -1, -2, -3);
        System.out.println(m3); // 5

        try {
            int m4 = max();
            System.out.println(m4);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage()); // Cannot find max of empty array.
        }
    }

    public static int max(int number) {
        return number;
    }

    public static int max(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Cannot find max of empty or null array.");
        }

        int max = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }
}