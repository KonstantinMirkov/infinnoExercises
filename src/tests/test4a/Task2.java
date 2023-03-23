package tests.test4a;

public class Task2 {
    public static void main(String[] args) {
        String date = "30-11-2021";
        System.out.println(getDayOfWeek(date)); // 2

        try {
            String date2 = "";
            System.out.println(getDayOfWeek(date2));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Date cannot be null or empty.
        }
    }

    public static int getDayOfWeek(String date) {
        if (date == null || date.length() == 0) {
            throw new IllegalArgumentException("Date cannot be null or empty.");
        }

        String[] parts = date.split("-");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        int[] t = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        if (month < 3) {
            year -= 1;
        }

        return (year + year / 4 - year / 100 + year / 400 + t[month - 1] + day) % 7;
    }
}
