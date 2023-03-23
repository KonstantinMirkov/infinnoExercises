package oopExamples.enumeration;

public enum WeekDays {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static WeekDays[] workingDays() {
        return new WeekDays[]{MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,};

    }
}
