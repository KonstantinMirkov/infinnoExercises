package homeworks.homework29;

public class Task4 {
    public static void main(String[] args) {
        System.out.println(before("12-12-2020", "11-12-2020")); // false
        System.out.println(before("11-12-2020", "12-12-2020")); // true
        System.out.println(before("11-12-2020", "12-12-2021")); // true
    }

    public static boolean before(String date1, String date2) {
        if (date1 == null || date2 == null || date1.isEmpty() || date2.isEmpty()) {
            return false;
        }

        String[] d1 = date1.split("-");
        String[] d2 = date2.split("-");

        int year1 = Integer.parseInt(d1[2]);
        int year2 = Integer.parseInt(d2[2]);
        if (year1 != year2) {
            return year1 < year2;
        }

        int month1 = Integer.parseInt(d1[1]);
        int month2 = Integer.parseInt(d2[1]);
        if (month1 != month2) {
            return month1 < month2;
        }

        int day1 = Integer.parseInt(d1[0]);
        int day2 = Integer.parseInt(d2[0]);
        return day1 < day2;
    }
}