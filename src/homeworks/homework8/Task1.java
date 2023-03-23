package homeworks.homework8;

public class Task1 {
    static final int[] DAYS_IN_MONTHS = {0, 0, 31, 59, 90, 121, 151, 182, 212, 243, 273, 304, 334};

    public static void main(String[] args) {
        System.out.println(daysBetween("11-06-2021", "12-06-2021")); //1
        System.out.println(daysBetween("1-01-2021", "1-02-2021")); //31
        System.out.println(daysBetween("2-02-2016", "1-02-2021")); //1825
        System.out.println(daysBetween("1-02-2021", "1-02-2017")); //Exception because firstDate > secondDate

    }

    public static int daysBetween(String date1, String date2) {
        if (date1 == null || date1.length() == 0
                || date2 == null || date2.length() == 0) {
            throw new IllegalArgumentException("Dates cannot be null or empty.");
        }

        int days1 = getDaysSinceEpoch(date1);
        int days2 = getDaysSinceEpoch(date2);

        int daysDiff = days2 - days1;

        if (daysDiff < 0) {
            throw new IllegalArgumentException("First date cannot be greater than the second date.");
        }

        return daysDiff;
    }

    public static int getDaysSinceEpoch(String date) {
        String[] parts = date.split("-");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        return calculateDays(day, month, year);
    }

    private static int calculateDays(int day, int month, int year) {
        int days = (year - 1970) * 365;

        int leapYearsCount = (year - 1970) / 4 - year / 100 + year / 400;
        days += leapYearsCount;

        days += DAYS_IN_MONTHS[month];

        if (isLeapYear(year) && ((month == 2 && day == 29) || month > 2)) {
            days++;
        }

        return days + day;
    }

    public static boolean isLeapYear(int year) {
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
