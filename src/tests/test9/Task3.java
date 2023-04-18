package tests.test9;

public class Task3 {
    public static void main(String[] args) {
        int year1 = 2000;
        int year2 = 2020;
        System.out.println(countLeapYears(year1, year2)); // 6
    }

    public static int countLeapYears(int year1, int year2) {
        if (year1 < 0 || year2 < 0) {
            throw new IllegalArgumentException("Years cannot be a negative number.");
        }

        int count = 0;
        for (int i = year1; i <= year2; i++) {
            if (isLeapYear(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }
}
