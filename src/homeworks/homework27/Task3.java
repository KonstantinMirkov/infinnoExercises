package homeworks.homework27;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task3 {
    public static void main(String[] args) {
        int n = 3;
        String date1 = "21-02-2021";
        System.out.println(addDays(date1, n)); // 24-02-2021

        String date2 = "31-12-2021";
        System.out.println(addDays(date2, n)); // 03-01-2022

        String date3 = "";
        System.out.println(addDays(date3, n)); // Date must not be null or empty.

        String date4 = "31-12-2021";
        System.out.println(addDays(date4, -4)); // N cannot be a negative number.
    }

    public static String addDays(String date, int n) {
        if (date == null || date.isEmpty()) {
            return "Date must not be null or empty.";
        }

        if (n < 0) {
            return "N cannot be a negative number.";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);

        localDate = localDate.plusDays(n);

        return localDate.format(formatter);
    }
}
