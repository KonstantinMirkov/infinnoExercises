package tests.test9;

public class Task4 {
    public static void main(String[] args) {
        System.out.println(validDate("12-12-2012")); // true
        System.out.println(validDate("30-02-2012")); // false
    }

    public static boolean validDate(String date) {
        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException("Date cannot be null or empty.");
        }

        String[] parts = date.split("-");

        if (parts.length != 3) {
            return false;
        }

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        if (month < 1 || month > 12) {
            return false;
        }

        int daysInMonth = getDaysInMonth(month, year);
        if (day < 1 || day > daysInMonth) {
            return false;
        }

        return true;
    }

    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
            case 4, 6, 9, 11:
                return 30;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
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
