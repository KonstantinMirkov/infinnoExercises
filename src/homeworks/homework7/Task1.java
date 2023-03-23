package homeworks.homework7;

public class Task1 {
    public static void main(String[] args) {
        String schedule = "KKK";
        System.out.println(rememberSchool(schedule));

        schedule = "ППОЗЗП";
        System.out.println(rememberSchool(schedule));

        schedule = "PPОЗЗЗ";
        System.out.println(rememberSchool(schedule));
    }

    public static boolean rememberSchool(String schedule) {
        int absences = 0;
        int beingLateDays = 0;

        int days = 0;
        while (days < schedule.length()) {
            char day = schedule.charAt(days);
            switch (day) {
                case 'О', 'O' -> {
                    absences++;
                    if (absences > 2) {
                        return false;
                    }
                    beingLateDays = 0;
                }
                case 'З', 'Z' -> {
                    beingLateDays++;
                    if (beingLateDays >= 3) {
                        return false;
                    }
                }
                case 'П', 'P' -> beingLateDays = 0;

                default -> {
                    System.out.print("Wrong input - ");
                    return false;
                }
            }
            days++;
        }

        return true;
    }
}
